package com.example.fox.besproject.files_dz6;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fox.besproject.R;
import com.example.fox.besproject.files_dz3.CircularTransformation;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StudentAddapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Student> dataList;
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
        Student studient = dataList.get(position);
        Holder itemHolder = (Holder)holder;

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
                Intent intent = new Intent(view.getContext(), InfoStudent.class);
                Student infoStudent = dataList.get(position);

                InfoStudent.addInfoStudent(
                        infoStudent.getName(),
                        infoStudent.getSurname(),
                        infoStudent.getGroup(),
                        infoStudent.getPhone(),
                        infoStudent.getFotos(),
                        position
                );

                view.getContext().startActivity(intent);
            }
        });
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
