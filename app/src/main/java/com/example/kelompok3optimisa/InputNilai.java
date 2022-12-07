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
import android.widget.ImageButton;

public class InputNilai extends AppCompatActivity {

    private static final String CHANNEL_ID = "Inputnilai_kanal";
    ImageButton BtnHome, BtnProfil, BtnBack, BtnListLogbook;
    private Button btn_seminarkp;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nilai);

        BtnHome = findViewById(R.id.btn_home);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnBack = findViewById(R.id.btn_back);
        BtnListLogbook = findViewById(R.id.btn_logbook);


        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(InputNilai.this, MainActivity.class);
            startActivity(home);
        });

        BtnProfil.setOnClickListener(view -> {
            Intent profil = new Intent(InputNilai.this, ProfilActivity.class);
            startActivity(profil);
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(InputNilai.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnBack.setOnClickListener(view -> {
            Intent back = new Intent(InputNilai.this, MainActivity.class);
            startActivity(back);
        });

        //1. Ambil notifikationManager
        notificationManager = NotificationManagerCompat.from(this);

        //2b Buat channel notifikasi
        createNotificationChannel();

        btn_seminarkp = findViewById(R.id.btn_seminarkp);
        btn_seminarkp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(InputNilai.this, InputNilai.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(InputNilai.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                //3. Buat builder untuk membuat notifikasi
                NotificationCompat.Builder builder = new NotificationCompat.Builder(InputNilai.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_baseline_notification)
                        .setContentTitle("UPDATE NILAI")
                        .setContentText("Baru saja Anda melakukan Update nilai KP Mahasiswa")
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.ic_baseline_notification, "LIHAT", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);



                //4. Buat objek notifikasi
                Notification notification = builder.build();

                //5. Tampilkan notifikasi
                notificationManager.notify(102, notification);
            }
        });
    }

    //2. Buat channel
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Kanal Input Nilai", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Kanal notifikasi Input Nilai");
            notificationManager.createNotificationChannel(channel);

        }
    }
}