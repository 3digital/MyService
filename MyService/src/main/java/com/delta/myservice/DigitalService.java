package com.delta.myservice;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by 3digital on 9/11/13.
 */
public class DigitalService extends IntentService{
    public DigitalService() {
        super("digital");

    }



    @Override
    protected void onHandleIntent(Intent intent) {

        Toast.makeText(this, "OH MY GOD THIS SERVICE IS AMAZING!!!", Toast.LENGTH_SHORT).show();

    }


}
