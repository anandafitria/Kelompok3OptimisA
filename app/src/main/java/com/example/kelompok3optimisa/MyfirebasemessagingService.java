package com.example.kelompok3optimisa;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyfirebasemessagingService extends FirebaseMessagingService {

    private static final String CHANNEL_ID = "Login_kanal";
    private static final String TAG = "Service-Debug";
    private NotificationManagerCompat notificationManager;

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "Refreshed token: " + token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String tipe = remoteMessage.getData().get("tipe");
        if (tipe.equals("1"))
        displayNotification(remoteMessage.getNotification());
        else
            displayNotification2(remoteMessage.getNotification());
        }

    private void displayNotification(RemoteMessage.Notification notification) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Kanal login", NotificationManager.IMPORTANCE_HIGH);
                channel.setDescription("Kanal notifikasi Login");
                NotificationManagerCompat.from(this).createNotificationChannel(channel);
            }
            NotificationCompat.Builder builder = null;

        //A. TIPE NOTIFIKASI 1
            Intent resultIntent = new Intent(this, ProfilActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        //3. Buat builder untuk membuat notifikasi
        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notification)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setContentIntent(resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //5. Tampilkan notifikasi
        NotificationManagerCompat.from(this).notify(101, builder.build());
    }

    private void displayNotification2(RemoteMessage.Notification notification) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Kanal login", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Kanal notifikasi Login");
            NotificationManagerCompat.from(this).createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = null;

        //3. Buat builder untuk membuat notifikasi
        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notification)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //5. Tampilkan notifikasi
        NotificationManagerCompat.from(this).notify(101, builder.build());
    }
}