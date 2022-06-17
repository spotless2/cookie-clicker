package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Shop extends AppCompatActivity {



    private TextView cookieCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        // updating the text showing the available cookies
        cookieCounter = (TextView) findViewById(R.id.shopCookies);
        cookieCounter.setText("Cookies: " + MainActivity.cookies);

        // settings for prices
        ((TextView)findViewById(R.id.txtPrice)).setText("Price: " + MainActivity.doublePrice);
        ((TextView)findViewById(R.id.txtPrice2)).setText("Price: " + MainActivity.autoclickerPrice);
        coloredPrice();
    }

    private void coloredPrice() {
        if (MainActivity.cookies >= MainActivity.doublePrice) {
            ((TextView)findViewById(R.id.txtPrice)).setTextColor(Color.GREEN);
        }
        else {
            ((TextView)findViewById(R.id.txtPrice)).setTextColor(Color.RED);
        }
        if (MainActivity.cookies >= MainActivity.autoclickerPrice) {
            ((TextView)findViewById(R.id.txtPrice2)).setTextColor(Color.GREEN);
        }
        else {
            ((TextView)findViewById(R.id.txtPrice2)).setTextColor(Color.RED);
        }
    }

    public void buyDouble(View view) {
        if (MainActivity.cookies >= MainActivity.doublePrice) {
            MainActivity.cookies -= MainActivity.doublePrice;
            MainActivity.doublePrice = (MainActivity.doublePrice * 2) + (MainActivity.doublePrice / 10);
            Toast.makeText(this, "You have bought Double cookies per click", Toast.LENGTH_LONG).show();
            ((TextView)findViewById(R.id.txtPrice)).setText("Price: " + MainActivity.doublePrice);
            cookieCounter.setText("Cookies: " + MainActivity.cookies);
            coloredPrice();
            MainActivity.cookieCounter *= 2;
        }
        else {
            Toast.makeText(this, "You don't have enough money", Toast.LENGTH_LONG).show();
        }
    }

    public void buyAutoclicker(View view) {
        if (MainActivity.cookies >= MainActivity.autoclickerPrice) {
            MainActivity.cookies -= MainActivity.autoclickerPrice;
            MainActivity.autoclickerPrice += 30;
            MainActivity.autoclickCounter += 2;
            MainActivity.taskCheck = true;
            Toast.makeText(this, "You have bought Autoclicker (+2 clicks/sec)", Toast.LENGTH_LONG).show();
            ((TextView)findViewById(R.id.txtPrice2)).setText("Price: " + MainActivity.autoclickerPrice);
            cookieCounter.setText("Cookies: " + MainActivity.cookies);
            coloredPrice();

        }
        else {
            Toast.makeText(this, "You don't have enough money", Toast.LENGTH_LONG).show();
        }
    }

    public void mainScreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        MainActivity.taskCheck = true;
    }
}