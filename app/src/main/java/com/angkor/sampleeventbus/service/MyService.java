package com.angkor.sampleeventbus.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by phuon on 02-Feb-17.
 */
public class MyService extends Service {

    private String TAG = "MyService.";
    private IBinder iBinder = new LocalService();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"OnBinding...");
        return iBinder;
    }





    public class LocalService extends Binder{

        public MyService getService(){
            return MyService.this;
        }
    }


}
