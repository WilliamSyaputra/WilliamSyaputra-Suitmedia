package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class SecondScreen extends AppCompatActivity {

    TextView name;
    TextView userName;
    Button choseUser;
    ImageButton back;

    String getName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        name = findViewById(R.id.tv_name);
        userName = findViewById(R.id.tv_userName);
        choseUser = findViewById(R.id.btn_chsUser);
        back = findViewById(R.id.btn_img_backSecond);

        Bundle extras = getIntent().getExtras();

        if (extras != null){
            getName = extras.getString("nameFromFirst");
            name.setText(getName);

            String getUserName = extras.getString("nameFromList");
            userName.setText(getUserName);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        choseUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThirdScreen.class);
                startActivity(intent);
            }
        });

    }
}