package com.example.fox.besproject.files_dz5;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.fox.besproject.Dz5Activity;

import java.util.concurrent.TimeUnit;

public class MyService extends Service {




    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("BBB","onCreate 111");





    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("BBB","onStartCommand 222");

        WifiManager wifiManager = (WifiManager) this.getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
            wifiManager.setWifiEnabled(true);


        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("BBB","onBind 333");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("BBB","onUnbind 444");
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.e("BBB","onDestroy BBB");

        WifiManager wifiManager = (WifiManager) this.getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(false);
    }
}
