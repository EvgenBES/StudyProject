package com.example.fox.besproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Dz2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz2);

// Animation
        overridePendingTransition(R.anim.up_and_down, R.anim.lost_activity_out);
    }
}
