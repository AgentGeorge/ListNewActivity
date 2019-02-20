package com.example.study4_listdetails.UI.Main;

import android.content.Context;

import com.example.study4_listdetails.Core.Car;

import java.util.List;

public interface MainView {
    void refreshAdapterData(List<Car> cars);
}
