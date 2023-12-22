package com.example.myapplication.Read;

import com.example.myapplication.model.getUser;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InterfaceApi {
    @GET("users")
    Call<getUser> getUser();

}
