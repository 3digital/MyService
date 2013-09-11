package com.delta.myservice;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent(this, MyService.class);
        startService(intent);

        Intent intent1 = new Intent(this, DigitalService.class);
        startService(intent1);

        Notification.Builder mBuilder = new Notification.Builder(this);
        mBuilder.setContentText("Hello delta program !");
        mBuilder.setContentTitle("DZ Notifications");
        mBuilder.setSmallIcon(R.drawable.ic_launcher);



        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = null;
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());




    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
