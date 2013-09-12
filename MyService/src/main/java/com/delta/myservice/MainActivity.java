package com.delta.myservice;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
    public DigitalService mDigitalReciever;


    @Override
    protected void onResume() {
        super.onResume();
        this.registerReceiver(mDigitalReciever, new IntentFilter("digital"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.unregisterReceiver(mDigitalReciever);
    }

    private class DigitalService extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            String message = "njknkn";
            Bundle extras = intent.getExtras();

            if (extras != null) {
                message = extras.getString("digital");
            }

            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDigitalReciever = new DigitalService();


        Intent intent = new Intent(this, MyService.class);
        startService(intent);

        Intent intent1 = new Intent(this, DigitalService.class);
        startService(intent1);

        Notification.Builder mBuilder = new Notification.Builder(this);
        mBuilder.setContentText("Hello Delta Program !");
        mBuilder.setContentTitle("Digital Notifications");
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
