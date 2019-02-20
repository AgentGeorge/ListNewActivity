package com.example.study4_listdetails.UI.Details;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
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

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.detailsTitle));

        Intent intent = getIntent();

        int ID = intent.getIntExtra("ID", 0);
        Car car = MainApp.getInstance().getDbHelper().getCarByID(ID);

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

        TextView textOverview = (TextView) findViewById(R.id.textParams);
        textOverview.setText(getString(R.string.car_params, engineVolume, enginePower));

        TextView textCost = (TextView) findViewById(R.id.textCost);
        textCost.setText(getString(R.string.car_cost, cost));

        TextView textDesc = (TextView) findViewById(R.id.textDesc);
//        textDesc.setMovementMethod(new ScrollingMovementMethod());
        textDesc.setText(descID);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
