package com.example.study4_listdetails.UI.Main;

import com.example.study4_listdetails.Core.Car;

import java.util.List;

public interface MainView {
    void refreshAdapterData(List<Car> cars);
}
