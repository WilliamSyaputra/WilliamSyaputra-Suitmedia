package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    EditText name, palin;
    Button check, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.et_name);
        palin = findViewById(R.id.et_palindrome);
        check = findViewById(R.id.btn_check);
        next = findViewById(R.id.btn_next);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = palin.getText().toString().replaceAll("\\s", "");

                if (inputText.isEmpty()){
                    Toast.makeText(getApplicationContext(), "You input Nothing", Toast.LENGTH_SHORT).show();
                }
                else if (isPalindrome(inputText)) {
                    Toast.makeText(getApplicationContext(), "Palindrome!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Not a palindrome!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondScreen.class);
                intent.putExtra("nameFromFirst", name.getText().toString());
                intent.putExtra("nameFromList", "Selected User Name");
                startActivity(intent);
            }
        });
    }

    private boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}