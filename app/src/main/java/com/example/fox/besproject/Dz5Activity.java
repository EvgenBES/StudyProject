package com.example.fox.besproject;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fox.besproject.files_dz5.MyService;

public class Dz5Activity extends AppCompatActivity {
    ImageView imageView;
    TextView statusText;
    Switch toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz5);
        imageView = findViewById(R.id.imageTestWifi);
        statusText = findViewById(R.id.textViewDz5);

        this.registerReceiver(this.broadcastReceiver,
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));


        toggle = findViewById(R.id.wifi_switch_dz5);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggleWiFi(true);
                    Toast.makeText(getApplicationContext(), "Wi-Fi Enabled!", Toast.LENGTH_LONG).show();
                } else {
                    toggleWiFi(false);
                    Toast.makeText(getApplicationContext(), "Wi-Fi Disabled!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void toggleWiFi(boolean status) {
        WifiManager wifiManager = (WifiManager) this.getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
        if (status == true && !wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        } else if (status == false && wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(false);
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        //запуск Servica
        startService(new Intent(this, MyService.class));


        bindService(new Intent(this, Dz5Activity.class), serviceConnection, BIND_AUTO_CREATE);
        IntentFilter intentFilter = new IntentFilter();

        ConnectivityManager conMngr = (ConnectivityManager)this.getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = conMngr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        boolean isConnected = wifi != null && wifi.isConnectedOrConnecting();
        if (isConnected) {
            toggle.setChecked(true);

        } else {
            toggle.setChecked(false);
        }

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

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("AAQQ", "onServiceConnected hello");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("AAQQ", "onServiceDisconnected bay");
        }
    };



    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            String reason = intent.getStringExtra(ConnectivityManager.EXTRA_REASON);
            boolean isFailover = intent.getBooleanExtra(ConnectivityManager.EXTRA_IS_FAILOVER, false);

            NetworkInfo currentNetworkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            NetworkInfo otherNetworkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_OTHER_NETWORK_INFO);


            if(currentNetworkInfo.isConnected()){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_ok_wifi_75dp));
                statusText.setText("Status WiFi: OK");
                toggle.setChecked(true);
                statusText.setTextColor(Color.rgb(0, 153, 10));
            }else{
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_off_wifi_75dp));
                statusText.setText("Status WiFi: OFF");
                toggle.setChecked(false);
                statusText.setTextColor(Color.rgb(214, 0, 0));
            }
        }
    };

}
