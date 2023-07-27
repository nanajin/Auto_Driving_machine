package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
// import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;


public class Operation extends AppCompatActivity {

    Button highBtn, offBtn, lowBtn, resetBtn;
    String myMessage = "";
    String editTextAddress = "192.168.0.8";
    String editTextPort = "8888";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operation);

//        getSupportActionBar().setElevation(0);

        highBtn.setOnClickListener(v -> {
            MyClientTask myClientTask = new MyClientTask(editTextAddress, Integer.parseInt(editTextPort));
            myClientTask.execute();
            myMessage = "HIGH";
            //messageText.setText("");
        });

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

        Button next_btn = findViewById(R.id.next_button);
        next_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Operation_next.class);
            startActivity(intent);
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
//                myMessage = myMessage.toString();
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
    }
}
