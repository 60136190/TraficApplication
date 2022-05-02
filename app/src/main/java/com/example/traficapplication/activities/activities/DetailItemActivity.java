package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.traficapplication.R;

public class DetailItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detai_iitem);

        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b.get("detail").equals("Xe may")){

        }
    }
}