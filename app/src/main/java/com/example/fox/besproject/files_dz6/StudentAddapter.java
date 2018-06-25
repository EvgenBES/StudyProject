package com.example.fox.besproject.files_dz6;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fox.besproject.R;
import com.example.fox.besproject.files_dz3.CircularTransformation;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StudentAddapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Student> dataList;

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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Student studient = dataList.get(position);
        Holder itemHolder = (Holder)holder;

        itemHolder.nameTextView.setText(studient.getName());
        itemHolder.surnameTextView.setText(studient.getSurname());
        itemHolder.group_number.setText(studient.getGroup());
        Picasso.get()
                .load(studient.getFotos())
                .placeholder(R.drawable.ic_hourglass_empty_black_24dp)
                .error(R.drawable.ic_perm_scan_wifi_black_24dp)
                .transform(new CircularTransformation())
                .into(itemHolder.imageAvatar);


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
