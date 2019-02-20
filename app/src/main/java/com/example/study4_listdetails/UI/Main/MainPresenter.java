package com.example.study4_listdetails.UI.Main;

import android.content.Intent;

import com.example.study4_listdetails.Core.Car;
import com.example.study4_listdetails.Core.DbHelper;
import com.example.study4_listdetails.MainApp;
import com.example.study4_listdetails.UI.Details.DetailsActivity;

import java.util.List;

public class MainPresenter {
    private DbHelper dbHelper;
    private MainView view;

    public void attachView(MainView mView){
        dbHelper = MainApp.getInstance().getDbHelper();
        List<Car> cars = dbHelper.getCars();
        view = mView;
        view.refreshAdapterData(cars);
    }

    public void detachView(){
        view = null;
    }

    public Car getCarByID(int ID) {
        return dbHelper.getCarByID(ID);
    }


    public void onItemClick(MainActivity mainActivity, int ID) {
        Intent intent = new Intent(mainActivity, DetailsActivity.class);
        intent.putExtra("ID", ID);

        mainActivity.startActivity(intent);
    }
}
