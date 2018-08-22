package com.nazer.saini.daggerapp.manager;


import com.nazer.saini.daggerapp.pojo.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("/api/users")
    Call<User> createUser(@Body User user);

}