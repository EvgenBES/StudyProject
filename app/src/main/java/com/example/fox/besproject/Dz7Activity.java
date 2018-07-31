package com.example.fox.besproject;

import android.content.res.Configuration;
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
    boolean statusFragment = false;

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    private Fragment idFragmen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration configuration = getResources().getConfiguration();

        if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
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
            statusFragment = true;
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
    protected void onPause() {
        super.onPause();
        windowSize = false;
        if (statusFragment) {
            getSupportFragmentManager().beginTransaction().remove(idFragmen).commit();
        }

    }
}



