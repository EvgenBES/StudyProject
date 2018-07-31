package com.example.fox.besproject.files_dz7;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.fox.besproject.Dz7Activity;
import com.example.fox.besproject.R;
import com.example.fox.besproject.files_dz3.CircularTransformation;
import com.example.fox.besproject.files_dz6.SinglStudent;
import com.example.fox.besproject.files_dz6.Student;
import com.example.fox.besproject.files_dz6.StudentAddapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FragmentList extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);


        final SinglStudent singlStudent = SinglStudent.getInstance();

        final StudentAddapterDz7 studentAddapterDz7 = new StudentAddapterDz7() {
            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {


                Student studient = dataList.get(position);

                StudentAddapterDz7.Holder itemHolder = (StudentAddapterDz7.Holder) holder;

                itemHolder.nameTextView.setText(studient.getName());
                itemHolder.surnameTextView.setText(studient.getSurname());
                itemHolder.group_number.setText(studient.getGroup());
                Picasso.get()
                        .load(studient.getFotos().toString())
                        .placeholder(R.drawable.ic_hourglass_empty_black_24dp)
                        .error(R.drawable.ic_perm_scan_wifi_black_24dp)
                        .transform(new CircularTransformation())
                        .into(itemHolder.imageAvatar);


                itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Student infoStudent = dataList.get(position);
                        Log.e("BBBBB", "PositionStudent : " + infoStudent);

                        FragmentInfo.addInfoStudent(
                                infoStudent.getName(),
                                infoStudent.getSurname(),
                                infoStudent.getGroup(),
                                infoStudent.getPhone(),
                                infoStudent.getFotos(),
                                position,
                                true
                        );

                         FragmentInfo fragmentInfo = new FragmentInfo();
                        ((Dz7Activity) getActivity()).addInfo(fragmentInfo);

                    }
                });
            }

        };


        studentAddapterDz7.setDataList(singlStudent.getArray());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(studentAddapterDz7);



    }
}

