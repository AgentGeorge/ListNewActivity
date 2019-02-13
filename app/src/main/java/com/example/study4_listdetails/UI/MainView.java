package com.example.study4_listdetails.UI;

import com.example.study4_listdetails.Core.Car;

import java.util.ArrayList;

public interface MainView {
    void refreshAdapterData(ArrayList<Car> cars);
}
