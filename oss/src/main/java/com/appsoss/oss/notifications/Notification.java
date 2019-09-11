package com.appsoss.oss.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class Notification {

    private static NotificationManager notificationManager;

    public static NotificationManager getManager(Context context) {

        if(notificationManager == null){
            notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return notificationManager;
    }

    public static void notify(Context context, Class clase, String channel_id, String name, String channel_desc, int icon, boolean lights, boolean vibration, boolean progress){
        final Intent intent = new Intent(context, clase);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        final PendingIntent pendingIntent = PendingIntent.getActivity(context, 0 /* Request code */, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(channel_id, name, NotificationManager.IMPORTANCE_DEFAULT);

            notificationChannel.setDescription(channel_desc);
            notificationChannel.enableLights(lights);
            notificationChannel.setLightColor(Color.GREEN);
            notificationChannel.setVibrationPattern(new long[]{0, 500, 200, 500});
            notificationChannel.enableVibration(vibration);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, channel_id)
                .setContentTitle("Credi Master")
                .setSmallIcon(icon)
                .setProgress(100, 0, true)
                .setContentText("Sincronizando con el Servidor")
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);


        notificationManager.notify(1122 /* ID of notification */, notificationBuilder.build());
    }

    public static void notify(NotificationConfig config){

        final Intent intent = new Intent(config.getContext(), config.getClase());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        final PendingIntent pendingIntent = PendingIntent.getActivity(config.getContext(), 0 /* Request code */, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        getManager(config.getContext());

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(config.getChannel_id(), config.getName(), NotificationManager.IMPORTANCE_DEFAULT);

            notificationChannel.setDescription(config.getChannel_description());
            notificationChannel.enableLights(config.isLights());
            notificationChannel.setLightColor(config.getLed_color());
            notificationChannel.setVibrationPattern(new long[]{0, 500, 200, 500});
            notificationChannel.enableVibration(config.isVibration());
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(config.getContext(), config.getChannel_id())
                .setContentTitle(config.getNotification_title())
                .setSmallIcon(config.getIcon())
                .setContentText(config.getContent())
                .setAutoCancel(config.isAuto_cancel())
                .setContentIntent(pendingIntent);

        if(config.isProgress()){
            notificationBuilder.setProgress(100, 0, true);
        }

        if (config.isSound()){
            notificationBuilder.setSound(defaultSoundUri);
        }

        if(config.isAuto_cancel()){
            notificationBuilder.setAutoCancel(true);
        }


        notificationManager.notify(1122 /* ID of notification */, notificationBuilder.build());

    }

}
