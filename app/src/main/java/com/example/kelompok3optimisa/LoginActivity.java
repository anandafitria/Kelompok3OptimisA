package com.example.kelompok3optimisa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kelompok3optimisa.API.ApiClient;
import com.example.kelompok3optimisa.API.LoginRequest;
import com.example.kelompok3optimisa.API.LoginResponse;
import com.example.kelompok3optimisa.API.UserService;
import com.example.kelompok3optimisa.room.AppDatabase;
import com.example.kelompok3optimisa.room.User;
import com.example.kelompok3optimisa.room.UserDao;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import okhttp3.OkHttpClient;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity-Debug";
    private static final String CHANNEL_ID = "Login_kanal";
    EditText NIDN, Password;

    private Button BtnLogin;
    private NotificationManagerCompat notificationManager;
    private EditText editNIDN, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }
                        // Get new FCM registration token
                        String token = task.getResult();
                        // Log and toast
                        Log.d(TAG, token);
                        Toast.makeText(LoginActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });
        cekLogin();
    }

    //2. Buat channel
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Kanal login", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Kanal notifikasi Login");
            notificationManager.createNotificationChannel(channel);

        }
    }

    public void cekLogin() {
        editNIDN = findViewById(R.id.edit_1);
        editPassword = findViewById(R.id.edit_2);
        BtnLogin = findViewById(R.id.btn_1);

        //1. Ambil notificationManager
        notificationManager = NotificationManagerCompat.from(this);

        //2b Buat channel notifikasi
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Kanal login", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Kanal notifikasi Login");
            notificationManager.createNotificationChannel(channel);
        }

        BtnLogin = findViewById(R.id.btn_1);

        BtnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";
                String username = editNIDN.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                Log.d("LoginAct-Debug", username + " : " +password);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                        .client(new OkHttpClient.Builder().build())
                                                .build();

                UserService client = retrofit.create(UserService.class);

                Call<LoginResponse> call = client.login(NIDN,Password);

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        LoginResponse loginResponse = response.body();
                        Log.d("LoginAct-Debug", response.toString());

                        if (loginResponse != null && LoginResponse.getMessage() == "succes") {
                            Toast.makeText(LoginActivity.this, "Sukses Login", Toast.LENGTH_SHORT).show();

                            String token = loginResponse.getLoginResult().getToken();

                            SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("TOKEN", token);
                            editor.apply();

                            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(mainIntent);
                        }
                        else{
                            Toast.makeText(LoginActivity.this,"Username dan Password Anda salah", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Gagal menghubungi server", Toast.LENGTH_SHORT).show();
                    }
                });


                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

                Intent resultIntent = new Intent(LoginActivity.this, ProfilActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(LoginActivity.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                //3. Buat builder untuk membuat notifikasi
                NotificationCompat.Builder builder = new NotificationCompat.Builder(LoginActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_baseline_notification)
                        .setContentTitle("INFO LOGIN")
                        .setContentText("Anda baru saja login menggunakan akun husnil*")
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.ic_baseline_notification, "LIHAT", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                //4. Buat objek notifikasi
                Notification notification = builder.build();

                //5. Tampilkan notifikasi
                notificationManager.notify(101, notification);

                //a. buat object db
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                                AppDatabase.class, "rooms.db")
                        .allowMainThreadQueries()
                        .build();

                //b. buat object dao
                UserDao dao = db.userDao();

                User user = new User();
                user.NIDN = username;
                user.password = password;

                dao.insert(user);
            }
        });
    }

}
