package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.room.Room;

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
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kelompok3optimisa.datamodels.LoginResponse;
import com.example.kelompok3optimisa.retrofit.ApiClient;
import com.example.kelompok3optimisa.retrofit.InterfaceDosen;
import com.example.kelompok3optimisa.room.AppDatabase;
import com.example.kelompok3optimisa.room.User;
import com.example.kelompok3optimisa.room.UserDao;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {


    private static final String CHANNEL_ID = "Login_kanal";
    EditText NIDN, Password;

    private Button BtnLogin;
    private NotificationManagerCompat notificationManager;

    InterfaceDosen interfaceDosen;
    SharedPreferences sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        BtnLogin = findViewById(R.id.btn_1);
        NIDN = findViewById(R.id.edit_1);
        Password = findViewById(R.id.edit_2);

        interfaceDosen = ApiClient.getClient().create(InterfaceDosen.class);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekLogin();
            }
        });

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
        String username= NIDN.getText().toString();
        String password = Password.getText().toString();

        //1. Ambil notificationManager
        notificationManager = NotificationManagerCompat.from(this);

        //2b Buat channel notifikasi
        createNotificationChannel();
        Call<LoginResponse> call = interfaceDosen.login(username, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (loginResponse != null) {
                    String token = loginResponse.getAuthorisation().getToken();
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("TOKEN", token);
                    editor.putString("USERNAME", NIDN.getText().toString());
                    editor.putString("PASSWORD", Password.getText().toString());
                    editor.putString("NAME", response.body().getUser().getName());
                    editor.putString("EMAIL", response.body().getUser().getEmail());
                    editor.commit();
                    Toast.makeText(LoginActivity.this, "Berhasil Login" + username, Toast.LENGTH_SHORT).show();
                    Intent homeIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(homeIntent);
                } else {
                    Toast.makeText(LoginActivity.this, "Username atau pasword salah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Gagal menghubungi Server", Toast.LENGTH_SHORT).show();

            }
        });
    }



////                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
////                startActivity(intent);
////
////                Intent resultIntent = new Intent(LoginActivity.this, ProfilActivity.class);
////                TaskStackBuilder stackBuilder = TaskStackBuilder.create(LoginActivity.this);
////                stackBuilder.addNextIntentWithParentStack(resultIntent);
////                PendingIntent resultPendingIntent =
////                        stackBuilder.getPendingIntent(0,
////                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
////
////                //3. Buat builder untuk membuat notifikasi
////                NotificationCompat.Builder builder = new NotificationCompat.Builder(LoginActivity.this, CHANNEL_ID)
////                        .setSmallIcon(R.drawable.ic_baseline_notification)
////                        .setContentTitle("INFO LOGIN")
////                        .setContentText("Anda baru saja login menggunakan akun husnil*")
////                        .setContentIntent(resultPendingIntent)
////                        .addAction(R.drawable.ic_baseline_notification, "LIHAT", resultPendingIntent)
////                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
////
////                //4. Buat objek notifikasi
////                Notification notification = builder.build();
////
////                //5. Tampilkan notifikasi
////                notificationManager.notify(101, notification);
////
////                //a. buat object db
////                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
////                                AppDatabase.class, "rooms.db")
////                        .allowMainThreadQueries()
////                        .build();
////
////                //b. buat object dao
////                UserDao dao = db.userDao();
////
////                User user = new User();
////                user.NIDN = username;
////                user.password = password;
////
////                dao.insert(user);
////            }
//        });

}
