package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.AsyncTask;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Control extends AppCompatActivity {
    Button goBtn, backBtn, leftBtn, rightBtn;
    String myMessage = "";
    String editTextAddress = "192.168.0.8";
    String editTextPort = "8888";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control);

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

//        getSupportActionBar().setElevation(0);

        goBtn = (Button) findViewById(R.id.up);
        backBtn = (Button) findViewById(R.id.down);
        rightBtn = (Button) findViewById(R.id.right);
        leftBtn = (Button) findViewById(R.id.left);

        goBtn.setOnClickListener(v -> {
            Control.MyClientTask myClientTask = new Control.MyClientTask(editTextAddress, Integer.parseInt(editTextPort));
            myClientTask.execute();
            myMessage = "GO";
            //messageText.setText("");
        });

        backBtn.setOnClickListener(v -> {
            Control.MyClientTask myClientTask = new Control.MyClientTask(editTextAddress, Integer.parseInt(editTextPort));
            myClientTask.execute();
            myMessage = "BACK";
            //messageText.setText("");
        });

        leftBtn.setOnClickListener(v -> {
            Control.MyClientTask myClientTask = new Control.MyClientTask(editTextAddress, Integer.parseInt(editTextPort));
            myClientTask.execute();
            myMessage = "LEFT";
            //messageText.setText("");
        });

        rightBtn.setOnClickListener(v -> {
            Control.MyClientTask myClientTask = new Control.MyClientTask(editTextAddress, Integer.parseInt(editTextPort));
            myClientTask.execute();
            myMessage = "RIGHT";
            //messageText.setText("");
        });
    }

    public class MyClientTask extends AsyncTask<Void, Void, Void> {
        String dstAddress;
        int dstPort;
        String response = "";

        //constructor
        MyClientTask(String addr, int port){
            dstAddress = addr;
            dstPort = port;
        }
        @Override
        protected Void doInBackground(Void... arg0) {

            Socket socket = null;
            myMessage = myMessage.toString();
            try {
                socket = new Socket(dstAddress, dstPort);
                //송신
                OutputStream out = socket.getOutputStream();
                out.write(myMessage.getBytes());

                //수신
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                byte[] buffer = new byte[1024];
                int bytesRead;
                InputStream inputStream = socket.getInputStream();
                /*
                 * notice:
                 * inputStream.read() will block if no data return
                 */
                while ((bytesRead = inputStream.read(buffer)) != -1){
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                    response += byteArrayOutputStream.toString("UTF-8");
                }
                response = "서버의 응답: " + response;

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "UnknownHostException: " + e.toString();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "IOException: " + e.toString();
            }finally{
                if(socket != null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }

//        Button up_btn = findViewById(R.id.up);
//        up_btn.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class); // class 바꾸기
//            startActivity(intent);
//        });
//        Button down_btn = findViewById(R.id.down);
//        down_btn.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class); // class 바꾸기
//            startActivity(intent);
//        });
//        Button right_btn = findViewById(R.id.right);
//        right_btn.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class); // class 바꾸기
//            startActivity(intent);
//        });
//        Button left_btn = findViewById(R.id.left);
//        left_btn.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class); // class 바꾸기
//            startActivity(intent);
//        });
    }
}
