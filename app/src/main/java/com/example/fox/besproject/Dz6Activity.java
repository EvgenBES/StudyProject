package com.example.fox.besproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fox.besproject.files_dz6.StudentAddapter;
import com.example.fox.besproject.files_dz6.Student;

import java.util.ArrayList;

public class Dz6Activity extends AppCompatActivity {


    RecyclerView recyclerView;
    private StudentAddapter studentAddapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz6);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Kirilston", "Subrect", "+375 44 485 45 45", "https://avatarko.ru/img/avatar/14/shlyapa_pistolet_Lego_13500.jpg", "15"));
        studentList.add(new Student("Kirilston2", "Subrect2", "+375 44 485 45 45", "https://avatarko.ru/img/avatar/14/igra_soldat_13506.jpg", "17"));
        studentList.add(new Student("Kirilston3", "Subrect3", "+375 44 485 45 45", "https://avatarko.ru/img/avatar/18/devushka_17296.jpg", "25"));
        studentList.add(new Student("Kirilston4", "Subrect4", "+375 44 485 45 45", "https://avatarko.ru/img/avatar/31/igra_Dota_2_Omniknight_30248.jpg", "25"));
        studentList.add(new Student("Kirilston5", "Subrect5", "+375 44 485 45 45", "https://avatarko.ru/img/avatar/8/zhivotnye_sobaka_7404.jpg", "15"));


        studentAddapter = new StudentAddapter();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(studentAddapter);

        studentAddapter.setDataList(studentList);
    }
}
