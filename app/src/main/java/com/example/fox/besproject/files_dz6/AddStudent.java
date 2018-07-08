package com.example.fox.besproject.files_dz6;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fox.besproject.Dz6Activity;
import com.example.fox.besproject.R;

public class AddStudent extends AppCompatActivity implements View.OnClickListener{

    Button buttonAddStudent;
    EditText editTextDz6Name, editTextDz6Surname,editTextDz6Group, editTextDz6Phone, editTextDz6Fotos;
    SinglStudent singlStudent = SinglStudent.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_study);

        buttonAddStudent = findViewById(R.id.buttonDz6AddStudent);
        editTextDz6Name = findViewById(R.id.editTextDz6Name);
        editTextDz6Surname = findViewById(R.id.editTextDz6Surname);
        editTextDz6Group = findViewById(R.id.editTextDz6Group);
        editTextDz6Phone = findViewById(R.id.editTextDz6Phone);
        editTextDz6Fotos = findViewById(R.id.editTextDz6Fotos);

        buttonAddStudent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonDz6AddStudent:
                singlStudent.addToArray(
                        editTextDz6Name.getText().toString(),
                        editTextDz6Surname.getText().toString(),
                        editTextDz6Phone.getText().toString(),
                        editTextDz6Fotos.getText().toString(),
                        editTextDz6Group.getText().toString()
                );

                Intent intent = new Intent(this, Dz6Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


//    list.add  Student("Kirilston5", "Subrect5", "+375 44 485 45 45", "https://avatarko.ru/img/avatar/8/zhivotnye_sobaka_7404.jpg", "15"));


}
