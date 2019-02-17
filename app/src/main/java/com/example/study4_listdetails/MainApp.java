package com.example.study4_listdetails;

import android.app.Application;

import com.example.study4_listdetails.UI.Main.MainPresenter;

public class MainApp extends Application {
    private MainPresenter mainPresenter;

    public MainPresenter getMainPresenter() {
        return mainPresenter;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mainPresenter = new MainPresenter();
    }

}
