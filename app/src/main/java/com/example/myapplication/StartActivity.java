package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

public class StartActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_display);
        new Handler().postDelayed(() -> {
//            Intent intent = new Intent(StartActivity.this, MainActivity.class);
            Intent intent = new Intent(StartActivity.this, Loginout.class);
            startActivity(intent);
        },3000);
//        StartThread s_thread = new StartThread(handler);
//        s_thread.start();
    }
//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            if (msg.what == 1) {
//                Intent intent = new Intent(StartActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        }
//    };
//    new Handler().postDelayed(new Runnable(){
//        @Override
//                public void run(){
//            Intent intent = new Intent(StartActivity.this, MainActivity.class);
//            startActivity(intent);
//        }
//    },3000);
}
