package com.nazer.saini.daggerapp.application;

import android.app.Application;
import android.support.v4.widget.DirectedAcyclicGraph;

import com.nazer.saini.daggerapp.manager.dagger.ApplicationComponent;
import com.nazer.saini.daggerapp.manager.dagger.DaggerApplicationComponent;
import com.nazer.saini.daggerapp.manager.dagger.module.AppModule;
import com.nazer.saini.daggerapp.manager.dagger.module.NetModule;


public class MyApplication extends Application {


    public static final String BASE_URL = "https://reqres.in";
    public static final String MANGO_BASE_URL = "https://api.sandbox.mangopay.com/v2.01/";


    private static MyApplication sAppContext;
    private ApplicationComponent mApplicationComponent;

    public static synchronized MyApplication getInstance() {
        return sAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = this;

        mApplicationComponent= DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(BASE_URL))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
