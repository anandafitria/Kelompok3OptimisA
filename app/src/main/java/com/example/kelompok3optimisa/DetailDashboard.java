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
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kelompok3optimisa.datamodels.ApprovePesertaSeminar;
import com.example.kelompok3optimisa.datamodels.PembatalanKpResponse;
import com.example.kelompok3optimisa.retrofit.ApiClient;
import com.example.kelompok3optimisa.retrofit.InterfaceDosen;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailDashboard extends AppCompatActivity {

    private static final String CHANNEL_ID = "Pembatalankp_kanal";
    String NamaMain, NimMain, TtlMain, AlamatMain, LokasiKPMain;
    TextView tvNamaMain, tvNimMain, tvTtlMain, tvAlamatMain, tvLokasiKPMain;
    Integer FotoMain;
    ImageView ivFotoMain;
    ImageButton BtnHome, BtnProfil, BtnBack, BtnListLogbook;
    Button BtnLogbookKP, BtnNilaiKP, BtnSeminarKP;
    InterfaceDosen interfaceDosen;
    SharedPreferences sharedPref;

    private Button BtnPembatalanKP;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dashboard);

        interfaceDosen = ApiClient.getClient().create(InterfaceDosen.class);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        String token = sharedPref.getString("TOKEN", "");

        Intent detailDashboard = getIntent();
        if(detailDashboard != null){

            FotoMain = detailDashboard.getIntExtra("Foto", 0);
            ivFotoMain = findViewById(R.id.iv_fotomain);
            ivFotoMain.setImageResource(FotoMain);

            NamaMain = detailDashboard.getStringExtra("Nama");
            tvNamaMain = findViewById(R.id.tv_namamain);
            tvNamaMain.setText(NamaMain);

            NimMain = detailDashboard.getStringExtra("NIM");
            tvNimMain = findViewById(R.id.tv_nimmain);
            tvNimMain.setText(NimMain);

            TtlMain = detailDashboard.getStringExtra("TTL");
            tvTtlMain = findViewById(R.id.tv_ttlmain);
            tvTtlMain.setText(TtlMain);

            AlamatMain = detailDashboard.getStringExtra("Alamat");
            tvAlamatMain = findViewById(R.id.tv_alamatmain);
            tvAlamatMain.setText(AlamatMain);

            LokasiKPMain = detailDashboard.getStringExtra("Lokasi KP");
            tvLokasiKPMain = findViewById(R.id.tv_lokasikpmain);
            tvLokasiKPMain.setText(LokasiKPMain);
        }

        BtnHome = findViewById(R.id.btn_home);
        BtnProfil = findViewById(R.id.btn_profil);
        BtnBack = findViewById(R.id.btn_back);
        BtnListLogbook = findViewById(R.id.btn_logbook);
        BtnNilaiKP = findViewById(R.id.btn_nilaikp);
        BtnSeminarKP = findViewById(R.id.btn_seminarkp);
        BtnLogbookKP = findViewById(R.id.btn_logbookkp);

        BtnHome.setOnClickListener(view -> {
            Intent home = new Intent(DetailDashboard.this, MainActivity.class);
            startActivity(home);
        });

        BtnProfil.setOnClickListener(view -> {
            Intent profil = new Intent(DetailDashboard.this, ProfilActivity.class);
            startActivity(profil);
        });

        BtnBack.setOnClickListener(view -> {
            Intent back = new Intent(DetailDashboard.this, MainActivity.class);
            startActivity(back);
        });

        BtnListLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listlogbook = new Intent(DetailDashboard.this, ListLogbook.class);
                startActivity(listlogbook);
            }
        });

        BtnLogbookKP.setOnClickListener(view -> {
            Intent back = new Intent(DetailDashboard.this, LogbookPribadi.class);
            startActivity(back);
        });

        BtnNilaiKP.setOnClickListener(view -> {
            Intent nilaikp = new Intent(DetailDashboard.this, InputNilai.class);
            startActivity(nilaikp);
        });

        BtnSeminarKP.setOnClickListener(view -> {
            Intent detailseminar = new Intent(DetailDashboard.this, DetailSeminar.class);
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

                Intent resultIntent = new Intent(DetailDashboard.this, InputNilai.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(DetailDashboard.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                //3. Buat builder untuk membuat notifikasi
                NotificationCompat.Builder builder = new NotificationCompat.Builder(DetailDashboard.this, CHANNEL_ID)
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

        BtnPembatalanKP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PembatalanKpResponse> call = interfaceDosen.pembatalanKp("Bearer " + token);

                call.enqueue(new Callback<PembatalanKpResponse>() {
                    @Override
                    public void onResponse(Call<PembatalanKpResponse> call, Response<PembatalanKpResponse> response) {
                        PembatalanKpResponse pembatalanKpResponse = response.body();
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.remove("TOKEN");
                        editor.apply();
                        finish();
                        Toast.makeText(DetailDashboard.this,"Pengajuan pembatalan KP selesai", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DetailDashboard.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<PembatalanKpResponse> call, Throwable t) {
                        Toast.makeText(DetailDashboard.this,"Pengajuan pembatalan KP gagal", Toast.LENGTH_SHORT).show();
                    }
                });
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