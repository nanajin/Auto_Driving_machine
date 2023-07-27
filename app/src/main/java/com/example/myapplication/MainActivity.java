package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageButton operation_btn = findViewById(R.id.operation_button);
        operation_btn.setOnClickListener(view -> {
        Intent o_intent = new Intent(getApplicationContext(), Operation.class);
        startActivity(o_intent);
    });

        ImageButton help_btn = findViewById(R.id.help_button);
        help_btn.setOnClickListener(view -> {
            Intent h_intent = new Intent(getApplicationContext(), Help.class);
            startActivity(h_intent);
        });

        ImageButton cctv_btn = findViewById(R.id.camera);
        cctv_btn.setOnClickListener(view -> {
            Intent ca_intent = new Intent(getApplicationContext(), Camera.class);
            startActivity(ca_intent);
        });

        ImageButton control_btn = findViewById(R.id.control_button);
        control_btn.setOnClickListener(view -> {
            Intent c_intent = new Intent(getApplicationContext(), Control.class);
            startActivity(c_intent);
        });

        ImageButton settings_btn = findViewById(R.id.settings_button);
        settings_btn.setOnClickListener(view -> {
            Intent s_intent = new Intent(getApplicationContext(), Settings.class);
            startActivity(s_intent);
        });
//
    }

//    public void on1(View v) {
//        Toast.makeText(getApplicationContext(),"1 눌렀음",Toast.LENGTH_SHORT).show();
//    }
//    public void on2(View v) {
//        Toast.makeText(getApplicationContext(),"2 눌렀음",Toast.LENGTH_SHORT).show();
//    }
}