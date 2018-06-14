package com.example.fox.besproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonDz1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        buttonDz1 = (Button) findViewById(R.id.buttonDz1);
        buttonDz1.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonDz1:
                Intent intent = new Intent(this, Dz1Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
