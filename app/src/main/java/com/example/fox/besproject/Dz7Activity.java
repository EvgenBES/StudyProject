package com.example.fox.besproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import com.example.fox.besproject.files_dz7.FragmentInfo;
import com.example.fox.besproject.files_dz7.FragmentList;

public class Dz7Activity extends FragmentActivity {

    boolean windowSize = false;


    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    private Fragment tempFragment = new FragmentInfo();
    private Fragment idFragmen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        if (width < 1023 && height < 1023) {
            setContentView(R.layout.activity_dz7);
        } else {
            setContentView(R.layout.activity_dz7table);
            windowSize = true;
        }

        transaction.replace(R.id.fragmentList, new FragmentList());
        transaction.commit();
    }


    public void addInfo(Fragment fragment) {
        if (!windowSize) {
            fragmentManager.beginTransaction().replace(R.id.fragmentList, fragment).commit();
        } else {
            idFragmen = fragment;
            fragmentManager.beginTransaction().replace(R.id.fragmentInfo, idFragmen).commit();
        }
    }

    public void refreshList(FragmentList fragmentList) {
        if (!windowSize) {
            fragmentManager.beginTransaction().replace(R.id.fragmentList, fragmentList).commit();
        } else {
            fragmentManager.beginTransaction().replace(R.id.fragmentList, fragmentList).commit();
            fragmentManager.beginTransaction().remove(idFragmen).commit();
        }
    }

    public void fragmentListRefresh(FragmentList fragmentListRefresh) {
        fragmentManager.beginTransaction().replace(R.id.fragmentList, fragmentListRefresh).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fragmentManager.beginTransaction().replace(R.id.fragmentInfo, tempFragment).commit();
        fragmentManager.beginTransaction().remove(tempFragment).commit();
    }
}



