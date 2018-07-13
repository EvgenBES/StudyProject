package com.example.fox.besproject.files_dz7;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fox.besproject.Dz7Activity;
import com.example.fox.besproject.R;
import com.example.fox.besproject.files_dz3.CircularTransformation;
import com.example.fox.besproject.files_dz6.InfoStudent;
import com.example.fox.besproject.files_dz6.SinglStudent;
import com.example.fox.besproject.files_dz6.Student;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StudentAddapterDz7 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Student> dataList;
    SinglStudent singlStudent = SinglStudent.getInstance();


    public void setDataList(ArrayList<Student> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }


    static class Holder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView surnameTextView;
        TextView group_number;
        ImageView imageAvatar;


        public Holder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            surnameTextView = itemView.findViewById(R.id.surnameTextView);
            group_number = itemView.findViewById(R.id.group_number);
            imageAvatar = itemView.findViewById(R.id.imageAvatar);

        }
    }
}
