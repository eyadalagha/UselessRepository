package com.example.iyad.jobschedular02;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by iyad on 8/15/2015.
 */
public class MyService extends IntentService{

    public MyService(){
        this("MyService");
    }

    public MyService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setContentText("My Notification : "+Calendar.getInstance().getTimeInMillis()/1000);
        builder.setContentTitle("Title");
        builder.setSmallIcon(R.drawable.ic_launcher);

        builder.setTicker("Notification received : ");
        Notification not = builder.build();

        NotificationManager manager = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1,not);
    }
}
