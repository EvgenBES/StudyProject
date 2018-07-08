package com.example.fox.besproject.files_dz6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fox.besproject.Dz6Activity;
import com.example.fox.besproject.R;
import com.example.fox.besproject.files_dz3.CircularTransformation;
import com.squareup.picasso.Picasso;

public class EditInfoStudent extends AppCompatActivity {

    Button buttonSave, buttonBack;
    ImageView editImageInfoAvatar;
    EditText editStudentName, editStudentSurname, editStudentGroups, editStudentPhone, editStudentAvatar;

    private static String name, surname, group, phone, avatar;
    private static int id;
    SinglStudent singlStudent = SinglStudent.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info_student);

        editImageInfoAvatar = findViewById(R.id.editImageInfoAvatar);
        editStudentName = findViewById(R.id.editStudentName);
        editStudentSurname = findViewById(R.id.editStudentSurname);
        editStudentGroups = findViewById(R.id.editStudentGroups);
        editStudentPhone = findViewById(R.id.editStudentPhone);
        editStudentAvatar = findViewById(R.id.editStudentAvatar);

        buttonSave = findViewById(R.id.buttonSaveEdit);
        buttonBack = findViewById(R.id.buttonBackEdit);

        Picasso.get()
                .load(avatar)
                .placeholder(R.drawable.ic_hourglass_empty_black_24dp)
                .error(R.drawable.noavatar)
                .transform(new CircularTransformation())
                .into(editImageInfoAvatar);


        editStudentName.setText(name);
        editStudentSurname.setText(surname);
        editStudentGroups.setText(group);
        editStudentPhone.setText(phone);
        editStudentAvatar.setText(avatar);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonSaveEdit:
                        singlStudent.setToArray(
                                editStudentName.getText().toString(),
                                editStudentSurname.getText().toString(),
                                editStudentGroups.getText().toString(),
                                editStudentAvatar.getText().toString(),
                                editStudentGroups.getText().toString(), id);

                        backActivity();

                        break;
                    case R.id.buttonBackEdit:
                        openInfoView();
                        break;
                }
            }
        };

        buttonBack.setOnClickListener(onClickListener);
        buttonSave.setOnClickListener(onClickListener);
    }


    public static void editInfoStudent(String infoName, String infoSurname, String infoGroup, String infoPhone, String infoAvatar, int idPosition) {
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
    void openInfoView() {
        Intent intent2 = new Intent(this, InfoStudent.class);
        startActivity(intent2);
    }
}
