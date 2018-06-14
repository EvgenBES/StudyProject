package com.example.fox.besproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dz1Activity extends AppCompatActivity implements View.OnClickListener{

    TextView text1ViewDz1, text2ViewDz1;
    Button buttonDz1ClickMe;
    int status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz1_activity);

        text1ViewDz1 = (TextView) findViewById(R.id.text1ViewDz1);
        text2ViewDz1 = (TextView) findViewById(R.id.text2ViewDz1);
        buttonDz1ClickMe = (Button) findViewById(R.id.buttonDz1ClickMe);


//First method click button
        buttonDz1ClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(Dz1Activity.this, "You click button Click Me", Toast.LENGTH_LONG);
                toast.show();

                switch (status) {
                    case 0:
                        text1ViewDz1.setText(R.string.text2Dz1);
                        text1ViewDz1.setTextColor(Color.rgb(255, 210, 64));
                        text1ViewDz1.setBackgroundColor(Color.rgb(48, 63, 159));
                        text2ViewDz1.setText(R.string.text1Dz1);
                        text2ViewDz1.setTextColor(Color.rgb(255, 255, 255));
                        text2ViewDz1.setBackgroundColor(Color.rgb(24, 131, 2));
                        status = 1;
                        break;
                    case 1:
                        text1ViewDz1.setText(R.string.text1Dz1);
                        text1ViewDz1.setTextColor(Color.rgb(255, 255, 255));
                        text1ViewDz1.setBackgroundColor(Color.rgb(24, 131, 2));
                        text2ViewDz1.setText(R.string.text2Dz1);
                        text2ViewDz1.setTextColor(Color.rgb(255, 210, 64));
                        text2ViewDz1.setBackgroundColor(Color.rgb(48, 63, 159));
                        status = 0;
                        break;
                    default:
                        break;
                }

            }
        });

//2 method click button
        text1ViewDz1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast toast = Toast.makeText(Dz1Activity.this, "You click TextView Left", Toast.LENGTH_SHORT);
        toast.show();

        switch (status) {
            case 0:
                text1ViewDz1.setText(R.string.text2Dz1);
                text1ViewDz1.setTextColor(Color.rgb(255, 210, 64));
                text1ViewDz1.setBackgroundColor(Color.rgb(48, 63, 159));
                text2ViewDz1.setText(R.string.text1Dz1);
                text2ViewDz1.setTextColor(Color.rgb(255, 255, 255));
                text2ViewDz1.setBackgroundColor(Color.rgb(24, 131, 2));
                status = 1;
                break;
            case 1:
                text1ViewDz1.setText(R.string.text1Dz1);
                text1ViewDz1.setTextColor(Color.rgb(255, 255, 255));
                text1ViewDz1.setBackgroundColor(Color.rgb(24, 131, 2));
                text2ViewDz1.setText(R.string.text2Dz1);
                text2ViewDz1.setTextColor(Color.rgb(255, 210, 64));
                text2ViewDz1.setBackgroundColor(Color.rgb(48, 63, 159));
                status = 0;
                break;
            default:
                break;
        }

    }


//3 Method click button
    public void changeTextView(View view){
        Toast toast = Toast.makeText(Dz1Activity.this, "You click TextView Right", Toast.LENGTH_SHORT);
        toast.show();

        switch (status) {
            case 0:
                text1ViewDz1.setText(R.string.text2Dz1);
                text1ViewDz1.setTextColor(Color.rgb(255, 210, 64));
                text1ViewDz1.setBackgroundColor(Color.rgb(48, 63, 159));
                text2ViewDz1.setText(R.string.text1Dz1);
                text2ViewDz1.setTextColor(Color.rgb(255, 255, 255));
                text2ViewDz1.setBackgroundColor(Color.rgb(24, 131, 2));
                status = 1;
                break;
            case 1:
                text1ViewDz1.setText(R.string.text1Dz1);
                text1ViewDz1.setTextColor(Color.rgb(255, 255, 255));
                text1ViewDz1.setBackgroundColor(Color.rgb(24, 131, 2));
                text2ViewDz1.setText(R.string.text2Dz1);
                text2ViewDz1.setTextColor(Color.rgb(255, 210, 64));
                text2ViewDz1.setBackgroundColor(Color.rgb(48, 63, 159));
                status = 0;
                break;
            default:
                break;
        }
    }
}
