package com.example.study4_listdetails.UI;

import com.example.study4_listdetails.Core.Car;
import com.example.study4_listdetails.Core.DbHelper;

import java.util.ArrayList;

public class MainPresenter {
    private DbHelper dbHelper;
    private MainView view;

    public MainPresenter() {
        this.dbHelper = new DbHelper();
    }

    public void setAdapterData() {
        ArrayList<Car> cars = dbHelper.getCars();
        view.refreshAdapterData(cars);
    }

    public void attachView(MainView mView){
        view = mView;
    }

    public void detachView(){
        view = null;
    }

    public Car getCarByPosition(int position) {
        return dbHelper.getCarByPosition(position);
    }
}
