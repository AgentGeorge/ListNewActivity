package com.example.study4_listdetails.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.study4_listdetails.Core.Car;
import com.example.study4_listdetails.MainApp;
import com.example.study4_listdetails.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();

        int position = intent.getIntExtra("position", 0);
        MainPresenter mainPresenter = ((MainApp)getApplicationContext()).getMainPresenter();
        Car car = mainPresenter.getCarByPosition(position);

        int imageID = car.imageID;
        String model = car.model;
        String engineVolume = car.engineVolume;
        String enginePower = car.enginePower;
        String cost = car.cost;
        int descID = car.descID;

        ImageView imageView = (ImageView) findViewById(R.id.imagePhoto);
        imageView.setImageResource(imageID);

        TextView textModel = (TextView) findViewById(R.id.textModel);
        textModel.setText(model);

        TextView textOverview = (TextView) findViewById(R.id.textOverview);
        textOverview.setText(engineVolume + " л  " + enginePower + " л.с.  " + cost + " руб.");

        TextView textDesc = (TextView) findViewById(R.id.textDesc);
        textDesc.setMovementMethod(new ScrollingMovementMethod());
        textDesc.setText(descID);
    }
}
