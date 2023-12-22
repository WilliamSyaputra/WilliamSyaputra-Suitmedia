package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.UserAdapter;
import com.example.myapplication.R;
import com.example.myapplication.Read.Api;
import com.example.myapplication.Read.InterfaceApi;
import com.example.myapplication.model.User;
import com.example.myapplication.model.getUser;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThirdScreen extends AppCompatActivity {

    InterfaceApi interfaceApi;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ImageButton back;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_screen);

        recyclerView = findViewById(R.id.rv_User);
        interfaceApi = Api.getRetrofit().create(InterfaceApi.class);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        back = findViewById(R.id.btn_img_backThird);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        refresh();
    }

    public void refresh(){
        Call<getUser> call = interfaceApi.getUser();
        call.enqueue(new Callback<getUser>() {
            @Override
            public void onResponse(Call<getUser> call, Response<getUser> response) {
                ArrayList<User> listUser = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data user: " + String.valueOf(listUser.size()));

                adapter = new UserAdapter(listUser);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<getUser> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}