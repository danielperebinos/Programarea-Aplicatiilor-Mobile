package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
//import com.example.fourthweek.Draw1;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MyClick(View v) {
        try {
            Intent myIntentA1A2 = new Intent(MainActivity.this, Draw1.class);
            startActivityForResult(myIntentA1A2, 1);
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}