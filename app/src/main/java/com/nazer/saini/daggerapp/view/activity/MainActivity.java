package com.nazer.saini.daggerapp.view.activity;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.nazer.saini.daggerapp.R;
import com.nazer.saini.daggerapp.application.MyApplication;
import com.nazer.saini.daggerapp.manager.ApiInterface;
import com.nazer.saini.daggerapp.pojo.User;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    ApiInterface apiInterface;
    @Inject
    Application application;

    String  TAG=this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        MyApplication.getInstance().getApplicationComponent().Inject(MainActivity.this);



        callApi();
    }

    /**
     Create new user
     **/
    public void callApi() {
        User user = new User("morpheus", "leader");
        Call<User> call1 = apiInterface.createUser(user);
        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user1 = response.body();

                Toast.makeText(getApplicationContext(), user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
            }
        });
    }

}
