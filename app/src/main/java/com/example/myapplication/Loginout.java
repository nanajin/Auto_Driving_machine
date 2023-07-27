package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginout extends AppCompatActivity {
    EditText id, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

//        String id_input = id.getText().toString();
//        String pw_input = pw.getText().toString();
//
//        if (id_input.equals("o1a4") && pw_input.equals("1234")) {
////            Toast.makeText(Loginout.this, "Login Success", Toast.LENGTH_SHORT).show();
//            Button login_btn = findViewById(R.id.login_button);
//            login_btn.setOnClickListener(view -> {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
//            });
//        }
//        else{
//            Button login_btn = findViewById(R.id.login_button);
//            login_btn.setOnClickListener(view -> {
//                Intent intent = new Intent(getApplicationContext(), Loginout.class);
//                startActivity(intent);
//            });
//            Toast.makeText(Loginout.this, "Login Failed", Toast.LENGTH_SHORT).show();
//        }
        Button login_btn = findViewById(R.id.login_button);
        login_btn.setOnClickListener(view -> {
            Toast.makeText(Loginout.this,"Login Success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}
