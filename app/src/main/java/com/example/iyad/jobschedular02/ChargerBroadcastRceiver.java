package com.example.iyad.jobschedular02;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by iyad on 8/16/2015.
 */
public class ChargerBroadcastRceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Calendar c = Calendar.getInstance();
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent serviceIntent = new Intent(context, MyService.class);
        PendingIntent pIntent = PendingIntent.getService(context, MainActivity.SERVICE_ID, serviceIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            manager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 5*1000, pIntent);
            Toast.makeText(context, "Task scheduled for 5 seconds", Toast.LENGTH_LONG).show();
        }else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            manager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 20*1000, pIntent);
            Toast.makeText(context, "Task scheduled for 20 seconds", Toast.LENGTH_LONG).show();

        }
    }
}
