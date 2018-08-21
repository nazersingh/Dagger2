package com.nazer.saini.daggerapp.view.activity;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nazer.saini.daggerapp.R;
import com.nazer.saini.daggerapp.application.MyApplication;
import com.nazer.saini.daggerapp.manager.ApiInterface;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ApiInterface apiInterface;
    @Inject
    Application application;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        MyApplication.getInstance().getApplicationComponent().Inject(MainActivity.this);



        callApi();
    }

    public void callApi() {

    }
}
