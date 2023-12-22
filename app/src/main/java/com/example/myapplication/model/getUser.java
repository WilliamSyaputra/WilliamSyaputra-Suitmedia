package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class getUser {

    @SerializedName("data")
    private ArrayList<User> data;

    @SerializedName("total")
    private String total;

    public ArrayList<User> getData() {
        return data;
    }

    public void setData(ArrayList<User> data) {
        this.data = data;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
