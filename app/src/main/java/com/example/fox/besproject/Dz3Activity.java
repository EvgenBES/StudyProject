package com.example.fox.besproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.fox.besproject.files_dz3.CircularTransformation;
import com.squareup.picasso.Picasso;

public class    Dz3Activity extends AppCompatActivity {
    ImageView imageView;

    EditText editTextDz3;
    Button loadButton, randomButton, transButton;
    String randomUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz3);

//Animation
        overridePendingTransition(R.anim.right_to_left, R.anim.lost_activity_out);

        imageView = findViewById(R.id.imageViewDz3);
        editTextDz3 = findViewById(R.id.editTextDz3);
        loadButton = findViewById(R.id.loadButton);
        randomButton = findViewById(R.id.randomButton);
        transButton = findViewById(R.id.transButton);



        View.OnClickListener OnClickListener = new View.OnClickListener(){
// Random Method (create int 1-5 and assigns url to string randomUrl)
            public void randomIntButton(){
                int random_number = 1 + (int) (Math.random() * 5);
                switch (random_number){
                    case 1:
                        randomUrl = "https://avatarko.ru/img/avatar/33/multfilm_mech_minion_32681.jpg";
                        break;
                    case 2:
                        randomUrl = "https://avatarko.ru/img/avatar/30/multfilm_eda_sport_Griffins_29419.jpg";
                        break;
                    case 3:
                        randomUrl = "https://avatarko.ru/img/avatar/23/multfilm_22820.jpg";
                        break;
                    case 4:
                        randomUrl = "https://avatarko.ru/img/avatar/19/multfilm_cyplyonok_18522.jpg";
                        break;
                    case 5:
                        randomUrl = "https://avatarko.ru/img/avatar/17/multfilm_lemur_16195.jpg";
                        break;
                }
            }

            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.loadButton:
                        Picasso.get()
                                .load(editTextDz3.getText().toString())
                                .placeholder(R.drawable.ic_hourglass_empty_black_24dp)
                                .error(R.drawable.ic_perm_scan_wifi_black_24dp)
                                .into(imageView);
                        break;

                    case R.id.randomButton:
                        randomIntButton();
                        Picasso.get()
                                .load(randomUrl)
                                .placeholder(R.drawable.ic_hourglass_empty_black_24dp)
                                .error(R.drawable.ic_perm_scan_wifi_black_24dp)
                                .into(imageView);
                        break;

                    case R.id.transButton:
                        Picasso.get()
                                .load(randomUrl)
                                .placeholder(R.drawable.ic_hourglass_empty_black_24dp)
                                .error(R.drawable.ic_perm_scan_wifi_black_24dp)
                                .transform(new CircularTransformation())
                                .into(imageView);
                        break;
                }
            }
        };

        loadButton.setOnClickListener(OnClickListener);
        randomButton.setOnClickListener(OnClickListener);
        transButton.setOnClickListener(OnClickListener);

    }






}
