package com.example.fox.besproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Dz3Activity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView;
    EditText editTextDz3;
    Button loadButton, randomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz3_activity);


        imageView = findViewById(R.id.imageViewDz3);
        editTextDz3 = findViewById(R.id.editTextDz3);
        loadButton = findViewById(R.id.loadButton);
        randomButton = findViewById(R.id.randomButton);


        randomButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Picasso.get()
                .load("https://avatarko.ru/img/avatar/33/multfilm_mech_minion_32681.jpg")
                .placeholder(R.drawable.ic_hourglass_empty_black_24dp)
                .error(R.drawable.ic_perm_scan_wifi_black_24dp)
                .into(imageView);
    }
}
