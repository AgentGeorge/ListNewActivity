package com.example.study4_listdetails;

import android.app.Application;

import com.example.study4_listdetails.Core.DbHelper;

public class MainApp extends Application {
    DbHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        dbHelper = new DbHelper();
    }

}
