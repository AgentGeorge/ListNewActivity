package com.example.study4_listdetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();

        int imageID = intent.getIntExtra("imageID", 0);
        String model = intent.getStringExtra("model");
        String engineVolume = intent.getStringExtra("engineVolume");
        String enginePower = intent.getStringExtra("enginePower");
        String cost = intent.getStringExtra("cost");
        int descID = intent.getIntExtra("descID", 0);

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
