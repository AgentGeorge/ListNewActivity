package com.example.study4_listdetails.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.study4_listdetails.Core.Car;
import com.example.study4_listdetails.MainApp;
import com.example.study4_listdetails.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ItemClickListener, MainView {
    MainPresenter mainPresenter;
    RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new RecyclerAdapter(this);
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);

        mainPresenter = ((MainApp)getApplicationContext()).getMainPresenter();
        mainPresenter.attachView(this);
        mainPresenter.setAdapterData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("position", position);

        this.startActivity(intent);
    }

    @Override
    public void refreshAdapterData(ArrayList<Car> cars) {
        mAdapter.setCars(cars);
        mAdapter.notifyDataSetChanged();
    }
}


