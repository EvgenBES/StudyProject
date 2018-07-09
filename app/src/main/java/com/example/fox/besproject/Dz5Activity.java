package com.example.fox.besproject;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fox.besproject.files_dz5.MyService;

public class Dz5Activity extends AppCompatActivity {
    ImageView imageView;
    TextView statusText;
    Button buttonOnOffWifi;
    MyService myService = new MyService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz5);
        imageView = findViewById(R.id.imageTestWifi);
        statusText = findViewById(R.id.textViewDz5);
        buttonOnOffWifi = findViewById(R.id.buttonOnOffWifi);

        this.registerReceiver(this.broadcastReceiver,
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        buttonOnOffWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                myService.turnOnOff(wifiManager);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //запуск Servica
        startService(new Intent(this, MyService.class));
        bindService(new Intent(this, Dz5Activity.class), serviceConnection, BIND_AUTO_CREATE);

        IntentFilter intentFilter = new IntentFilter();
        Log.e("AAQQ", "Start onResume. If Wifi On - setChecked switch true else switch false");

        registerReceiver(broadcastReceiver, intentFilter);
        // сверху, мы подписались на сообщения о том что мы подключаемся к интернету
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(serviceConnection);
        Log.e("AAQQ", "Start onPause");
        //cтоп Servica
        stopService(new Intent(this, MyService.class));
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

            if (wifiManager.isWifiEnabled()) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ok_wifi_75dp));
                statusText.setText("Status WiFi: OK");
                statusText.setTextColor(Color.rgb(0, 153, 10));
            } else {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_off_wifi_75dp));
                statusText.setText("Status WiFi: OFF");
                statusText.setTextColor(Color.rgb(214, 0, 0));
            }
        }
    };

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
}
