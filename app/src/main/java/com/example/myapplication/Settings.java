package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        ImageButton home_btn = findViewById(R.id.home_button);
        home_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

        ImageButton back_btn = findViewById(R.id.back_button);
        back_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
        Button logout_btn = findViewById(R.id.logout_button);
        logout_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Loginout.class); // 로그인 화면
            startActivity(intent);
        });

        Switch sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                Toast.makeText(getApplicationContext(), "On", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Off", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
