package com.example.study4_listdetails;

import android.app.Application;

import com.example.study4_listdetails.Core.DbHelper;
import com.example.study4_listdetails.UI.Main.MainPresenter;

public class MainApp extends Application {
    private static MainApp instance;
    private MainPresenter mainPresenter;
    private DbHelper dbHelper;

    public static MainApp getInstance(){
        return instance;
    }

    public MainPresenter getMainPresenter() {
        return mainPresenter;
    }

    public DbHelper getDbHelper() {
        return dbHelper;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dbHelper = DbHelper.getInstance();
        mainPresenter = new MainPresenter();
        instance = this;
    }

}
