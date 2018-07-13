package com.example.fox.besproject.files_dz7;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fox.besproject.Dz6Activity;
import com.example.fox.besproject.Dz7Activity;
import com.example.fox.besproject.R;
import com.example.fox.besproject.files_dz3.CircularTransformation;
import com.example.fox.besproject.files_dz6.EditInfoStudent;
import com.example.fox.besproject.files_dz6.SinglStudent;
import com.example.fox.besproject.files_dz6.StudentAddapter;
import com.squareup.picasso.Picasso;

public class FragmentInfo extends Fragment {

    Button editButton, deleteButton, saveButton;
    ImageView imageInfoAvatar;
    EditText infoStudentName, infoStudentSurname, infoStudentGroups, infoStudentPhone;
    public static boolean statusInfo = false;

    private static String name, surname, group, phone, avatar;
    private static int id;
    SinglStudent singlStudent = SinglStudent.getInstance();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editButton = getActivity().findViewById(R.id.buttonEditStudent);
        deleteButton = getActivity().findViewById(R.id.buttonDelStudent);
        saveButton = getActivity().findViewById(R.id.buttonSaveStudent);

        imageInfoAvatar = getActivity().findViewById(R.id.imageInfoAvatar);
        infoStudentName = getActivity().findViewById(R.id.infoStudentName);
        infoStudentSurname = getActivity().findViewById(R.id.infoStudentSurname);
        infoStudentGroups = getActivity().findViewById(R.id.infoStudentGroups);
        infoStudentPhone = getActivity().findViewById(R.id.infoStudentPhone);


        infoStudentName.setText(name);
        infoStudentSurname.setText(surname);
        infoStudentGroups.setText(group);
        infoStudentPhone.setText(phone);
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
                        Log.e("aaqq", "CLICK EDIT");

                        infoStudentName.setEnabled(true);
                        infoStudentName.setCursorVisible(true);

                        Log.e("SSSDD", " " + infoStudentName.getBackground());

                        infoStudentName.setEnabled(true);
                        infoStudentName.setCursorVisible(true);
                        infoStudentName.setBackgroundColor(Color.rgb(225,225,225));

                        infoStudentSurname.setEnabled(true);
                        infoStudentSurname.setCursorVisible(true);
                        infoStudentSurname.setBackgroundColor(Color.rgb(225,225,225));

                        infoStudentGroups.setEnabled(true);
                        infoStudentGroups.setCursorVisible(true);
                        infoStudentGroups.setBackgroundColor(Color.rgb(225,225,225));

                        infoStudentPhone.setEnabled(true);
                        infoStudentPhone.setCursorVisible(true);
                        infoStudentPhone.setBackgroundColor(Color.rgb(225,225,225));

                        editButton.setBackgroundColor(Color.rgb(225,225,225));
                        editButton.setEnabled(false);

                        saveButton.setEnabled(true);
                        saveButton.setBackgroundColor(Color.argb(175,64,174,0));
                        break;

                    case R.id.buttonSaveStudent:
                        Log.e("SSSDD", "Click Save ");

                        singlStudent.setToArray(
                                infoStudentName.getText().toString(),
                                infoStudentSurname.getText().toString(),
                                infoStudentPhone.getText().toString(),
                                avatar,
                                infoStudentGroups.getText().toString(),
                                id);
                        saveButton.setBackgroundColor(Color.rgb(225,225,225));
                        saveButton.setEnabled(false);

                        editButton.setEnabled(true);
                        editButton.setBackgroundColor(Color.argb(175,64,174,0));



                        infoStudentName.setEnabled(false);
                        infoStudentName.setCursorVisible(false);
                        infoStudentName.setBackgroundColor(Color.TRANSPARENT);

                        infoStudentSurname.setEnabled(false);
                        infoStudentSurname.setCursorVisible(false);
                        infoStudentSurname.setBackgroundColor(Color.TRANSPARENT);

                        infoStudentGroups.setEnabled(false);
                        infoStudentGroups.setCursorVisible(false);
                        infoStudentGroups.setBackgroundColor(Color.TRANSPARENT);

                        infoStudentPhone.setEnabled(false);
                        infoStudentPhone.setCursorVisible(false);
                        infoStudentPhone.setBackgroundColor(Color.TRANSPARENT);

                        FragmentList fragmentListRefresh = new FragmentList();
                        ((Dz7Activity) getActivity()).fragmentListRefresh(fragmentListRefresh);

                        break;
                    case R.id.buttonDelStudent:
                        singlStudent.getArray().remove(id);
                        Log.e("aaqq", "CLICK DEL");

                        FragmentList fragmentList = new FragmentList();
                        ((Dz7Activity) getActivity()).refreshList(fragmentList);
                }
            }
        };

        editButton.setOnClickListener(onClickListener);
        deleteButton.setOnClickListener(onClickListener);
        saveButton.setOnClickListener(onClickListener);

    }

    public static void addInfoStudent(String infoName, String infoSurname, String infoGroup, String infoPhone, String infoAvatar, int idPosition, boolean status) {
        name = infoName;
        surname = infoSurname;
        group = infoGroup;
        phone = infoPhone;
        avatar = infoAvatar;
        id = idPosition;
        statusInfo = status;
    }
}


