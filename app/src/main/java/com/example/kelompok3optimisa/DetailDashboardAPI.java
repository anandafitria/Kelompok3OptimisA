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
import android.widget.ImageView;
import android.widget.TextView;

public class DetailDashboardAPI extends AppCompatActivity {

    private static final String CHANNEL_ID = "Pembatalankp_kanal";
    String NamaDashboard, NimDashboard, TtlDashboard, AlamatDashboard, LokasiKPDashboard;
    TextView tvNamaDashboard, tvNimDashboard, tvTtlDashboard, tvAlamatDashboard, tvLokasiKPDashboard;
    Integer FotoDashboard;
    ImageView ivFotoDashboard;
    ImageButton BtnHome, BtnProfil, BtnBack, BtnListLogbook;
    Button BtnLogbookKP, BtnNilaiKP, BtnSeminarKP;

    private Button BtnPembatalanKP;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_api);

        Intent detailDashboardAPI = getIntent();
        if(detailDashboardAPI != null){

            FotoDashboard = detailDashboardAPI.getIntExtra("Foto", 0);
            ivFotoDashboard = findViewById(R.id.iv_fotomain);
            ivFotoDashboard.setImageResource(FotoDashboard);

            NamaDashboard = detailDashboardAPI.getStringExtra("Nama");
            tvNamaDashboard = findViewById(R.id.tv_namamain);
            tvNamaDashboard.setText(NamaDashboard);

            NimDashboard = detailDashboardAPI.getStringExtra("NIM");
            tvNimDashboard = findViewById(R.id.tv_nimmain);
            tvNimDashboard.setText(NimDashboard);

            TtlDashboard = detailDashboardAPI.getStringExtra("TTL");
            tvTtlDashboard = findViewById(R.id.tv_ttlmain);
            tvTtlDashboard.setText(TtlDashboard);

            AlamatDashboard = detailDashboardAPI.getStringExtra("Alamat");
            tvAlamatDashboard = findViewById(R.id.tv_alamatmain);
            tvAlamatDashboard.setText(AlamatDashboard);

            LokasiKPDashboard = detailDashboardAPI.getStringExtra("Lokasi KP");
            tvLokasiKPDashboard = findViewById(R.id.tv_lokasikpmain);
            tvLokasiKPDashboard.setText(LokasiKPDashboard);
        }

        BtnHome = findViewById(R.id.btn_home);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnBack = findViewById(R.id.btn_back);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnNilaiKP = findViewById(R.id.btn_nilaikp);
        BtnSeminarKP = findViewById(R.id.btn_seminarkp);
        BtnLogbookKP = findViewById(R.id.btn_logbookkp);

        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(DetailDashboardAPI.this, MainActivity.class);
            startActivity(home);
        });

        BtnProfil.setOnClickListener(view -> {
            Intent profil = new Intent(DetailDashboardAPI.this, ProfilActivity.class);
            startActivity(profil);
        });

        BtnBack.setOnClickListener(view -> {
            Intent back = new Intent(DetailDashboardAPI.this, MainActivity.class);
            startActivity(back);
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(DetailDashboardAPI.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnLogbookKP.setOnClickListener(view -> {
            Intent back = new Intent(DetailDashboardAPI.this, DetailLogbook.class);
            startActivity(back);
        });

        BtnNilaiKP.setOnClickListener(view -> {
            Intent nilaikp = new Intent(DetailDashboardAPI.this, InputNilai.class);
            startActivity(nilaikp);
        });

        BtnSeminarKP.setOnClickListener(view -> {
            Intent detailseminar = new Intent(DetailDashboardAPI.this, DetailSeminar.class);
            startActivity(detailseminar);
        });

        //1. Ambil notifikationManager
        notificationManager = NotificationManagerCompat.from(this);

        //2b Buat channel notifikasi
        createNotificationChannel();

        BtnPembatalanKP = findViewById(R.id.btn_pembatalankp);
        BtnPembatalanKP.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(DetailDashboardAPI.this, InputNilai.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(DetailDashboardAPI.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                //3. Buat builder untuk membuat notifikasi
                NotificationCompat.Builder builder = new NotificationCompat.Builder(DetailDashboardAPI.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_baseline_notification)
                        .setContentTitle("UPDATE KP")
                        .setContentText("Baru saja Anda melakukan pembatalan KP Mahasiswa")
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.ic_baseline_notification, "LIHAT", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);



                //4. Buat objek notifikasi
                Notification notification = builder.build();

                //5. Tampilkan notifikasi
                notificationManager.notify(103, notification);
            }
        });
    }
    //2. Buat channel
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Kanal Pembatalan KP", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Kanal notifikasi Pembatalan KP");
            notificationManager.createNotificationChannel(channel);

        }
    }
}