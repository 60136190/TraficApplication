package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.traficapplication.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailSignalActivity extends AppCompatActivity {

    private TextView tvSignalName;
    private TextView tvSignalDetail;
    private CircleImageView cImgSignal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_signal);
        initUi();
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            String signalDetail = (String) b.get("detail");
            tvSignalDetail.setText(signalDetail);
            int img = (int) b.get("img");
            cImgSignal.setImageResource(img);
            String signalName =(String) b.get("name");
            tvSignalName.setText(signalName);
        }
    }

    private void initUi() {
        tvSignalName = findViewById(R.id.tv_signal_name_detail);
        cImgSignal = findViewById(R.id.img_signal_detail);
        tvSignalDetail = findViewById(R.id.tv_describe_detail);

    }
}