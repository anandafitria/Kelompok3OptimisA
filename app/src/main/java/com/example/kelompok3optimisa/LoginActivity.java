package com.example.kelompok3optimisa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private static final String CHANNEL_ID = "Login_kanal";
    EditText NIDN, Password;

    private Button BtnLogin;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        NIDN = findViewById(R.id.edit_1);
        Password = findViewById(R.id.edit_2);
        BtnLogin = findViewById(R.id.btn_1);

        //1. Ambil notificationManager
        notificationManager = NotificationManagerCompat.from(this);

        //2b Buat channel notifikasi
        createNotificationChannel();

        BtnLogin = findViewById(R.id.btn_1);
        BtnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //isi action button
                Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();

                String username = NIDN.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if (username.isEmpty()) {
                    NIDN.setError("Silahkan isi NIDN Anda");
                    return;
                }

                if (password.isEmpty()) {
                    Password.setError("Silahkan isi password Anda");
                    return;
                }

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

}
