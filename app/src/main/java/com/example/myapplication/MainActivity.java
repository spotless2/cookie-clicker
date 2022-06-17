package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public static int cookies = 110;
    public static int cookieCounter = 1;
    public static int autoclickCounter = 0;
    public static int doublePrice = 50;
    public static int autoclickerPrice = 100;
    public static boolean taskCheck = false;


    private Button btnShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShop = (Button) findViewById(R.id.shop);
        ((TextView) findViewById(R.id.cookieInfo)).setText("Cookies: " + cookies);
        if (taskCheck)
        {
            Timer timer = new Timer();

            TimerTask task = new TimerTask(){
                public void run(){
                    cookies += autoclickCounter;
                    ((TextView)findViewById(R.id.cookieInfo)).setText("Cookies: " + cookies);
                    if (!taskCheck) {
                        cancel();
                    }
                }
            };
            timer.scheduleAtFixedRate(task, 0, 1000); //1000ms = 1sec
        }
    }

    public void cookieClick(View view) {
        cookies += cookieCounter;
        ((TextView)findViewById(R.id.cookieInfo)).setText("Cookies: " + cookies);
    }

    public void openShop(View view) {
        Intent intent = new Intent(this, Shop.class);
        startActivity(intent);
        taskCheck = false;
    }
}