package com.example.fox.besproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonDz1, buttonDz2, buttonDz3, buttonDz4, buttonDz5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        buttonDz1 = findViewById(R.id.buttonDz1);
        buttonDz2 = findViewById(R.id.buttonDz2);
        buttonDz3 = findViewById(R.id.buttonDz3);
        buttonDz4 = findViewById(R.id.buttonDz4);
        buttonDz5 = findViewById(R.id.buttonDz5);
        buttonDz1.setOnClickListener(this);
        buttonDz2.setOnClickListener(this);
        buttonDz3.setOnClickListener(this);
        buttonDz4.setOnClickListener(this);
        buttonDz5.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonDz1:
                Intent intent = new Intent(this, Dz1Activity.class);
                startActivity(intent);
                break;
            case R.id.buttonDz2:
                Intent intent2 = new Intent(this, Dz2Activity.class);
                startActivity(intent2);
                break;
            case R.id.buttonDz3:
                Intent intent3 = new Intent(this, Dz3Activity.class);
                startActivity(intent3);
                break;
            case R.id.buttonDz4:
                Intent intent4 = new Intent(this, Dz4Activity.class);
                startActivity(intent4);
                break;
            case R.id.buttonDz5:
                Intent intent5 = new Intent(this, Dz5Activity.class);
                startActivity(intent5);
                break;
            default:
                break;
        }
    }
}
