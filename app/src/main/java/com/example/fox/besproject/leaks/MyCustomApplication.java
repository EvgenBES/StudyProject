package com.example.fox.besproject.leaks;

import android.app.Application;
import android.content.Context;

import com.example.fox.besproject.BuildConfig;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class MyCustomApplication extends Application {
    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        MyCustomApplication application = (MyCustomApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG)
            refWatcher = LeakCanary.install(this);
    }
}

