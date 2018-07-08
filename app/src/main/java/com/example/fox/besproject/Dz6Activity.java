package com.example.fox.besproject;

import android.app.Person;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.fox.besproject.files_dz6.AddStudent;
import com.example.fox.besproject.files_dz6.SinglStudent;
import com.example.fox.besproject.files_dz6.Student;
import com.example.fox.besproject.files_dz6.StudentAddapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Dz6Activity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageViewAdd;
    RecyclerView recyclerView;
    EditText filterName;


    private StudentAddapter studentAddapter;

    SinglStudent singlStudent = SinglStudent.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz6);

        imageViewAdd = findViewById(R.id.imageViewAdd);

        studentAddapter = new StudentAddapter();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(studentAddapter);

        studentAddapter.setDataList(singlStudent.getArray());

        filterName = findViewById(R.id.filterName);
        filterName.addTextChangedListener(new TextWatcher() {
            List<Student> filterText = new ArrayList<>();

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                filterText.clear();
                for (int i = 0; i < singlStudent.getArray().size(); i++) {
                    if (singlStudent.getArray().get(i).getName().toLowerCase().contains(editable.toString().toLowerCase()) ||
                            singlStudent.getArray().get(i).getSurname().toLowerCase().contains(editable.toString().toLowerCase()) ||
                            singlStudent.getArray().get(i).getPhone().toLowerCase().contains(editable.toString().toLowerCase())) {
                        filterText.add(singlStudent.getArray().get(i));
                    }
                }
                studentAddapter.setDataList((ArrayList<Student>) filterText);
                recyclerView.setAdapter(studentAddapter);
            }
        });
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, AddStudent.class);
        startActivity(intent);
    }


}
