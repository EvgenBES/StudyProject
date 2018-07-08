package com.example.fox.besproject.files_dz6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fox.besproject.Dz1Activity;
import com.example.fox.besproject.Dz6Activity;
import com.example.fox.besproject.R;
import com.example.fox.besproject.files_dz3.CircularTransformation;
import com.squareup.picasso.Picasso;

public class InfoStudent extends AppCompatActivity {

    Button editButton, deleteButton;
    ImageView imageInfoAvatar;
    TextView infoStudentName, infoStudentSurname, infoStudentGroups, infoStudentPhone;

    private static String name, surname, group, phone, avatar;
    private static int id;
    SinglStudent singlStudent = SinglStudent.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_student);

        editButton = findViewById(R.id.buttonEditStudent);
        deleteButton = findViewById(R.id.buttonDelStudent);

        imageInfoAvatar = findViewById(R.id.imageInfoAvatar);
        infoStudentName = findViewById(R.id.infoStudentName);
        infoStudentSurname = findViewById(R.id.infoStudentSurname);
        infoStudentGroups = findViewById(R.id.infoStudentGroups);
        infoStudentPhone = findViewById(R.id.infoStudentPhone);

        infoStudentName.setText("Имя: " + name);
        infoStudentSurname.setText("Фамилия: " + surname);
        infoStudentGroups.setText("Номер группы: " + group);
        infoStudentPhone.setText("Номер телефона: " + phone);
        Picasso.get()
                .load(avatar)
                .placeholder(R.drawable.ic_hourglass_empty_black_24dp)
                .error(R.drawable.noavatar)
                .transform(new CircularTransformation())
                .into(imageInfoAvatar);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonEditStudent:
                        EditInfoStudent.editInfoStudent(name, surname, group, phone, avatar, id);
                        openEditView();
                        break;
                    case R.id.buttonDelStudent:
                        singlStudent.getArray().remove(id);
                        backActivity();
                }
            }
        };

        editButton.setOnClickListener(onClickListener);
        deleteButton.setOnClickListener(onClickListener);

    }

    public static void addInfoStudent(String infoName, String infoSurname, String infoGroup, String infoPhone, String infoAvatar, int idPosition) {
        name = infoName;
        surname = infoSurname;
        group = infoGroup;
        phone = infoPhone;
        avatar = infoAvatar;
        id = idPosition;
    }

    void backActivity() {
        Intent intent = new Intent(this, Dz6Activity.class);
        startActivity(intent);
    }
    void openEditView() {
        Intent intent2 = new Intent(this, EditInfoStudent.class);
        startActivity(intent2);
    }

}
