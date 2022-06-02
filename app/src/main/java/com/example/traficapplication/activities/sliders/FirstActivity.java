package com.example.traficapplication.activities.sliders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.MainActivity;
import com.example.traficapplication.activities.auth.LoginActivity;
import com.example.traficapplication.activities.utils.Contants;

public class FirstActivity extends AppCompatActivity {

    protected int _splashTime = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                    finish();
                SharedPreferences sharedPreferences = FirstActivity.this.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                if (sharedPreferences.getString(Contants.email, "").isEmpty()){
                    Intent i3 = new Intent(FirstActivity.this, SlideActivity.class);
                    startActivity(i3);
                }else{
                    Intent i3 = new Intent(FirstActivity.this, MainActivity.class);
                    startActivity(i3);
                    finish();
                }
            }
        }, _splashTime);
    }
}