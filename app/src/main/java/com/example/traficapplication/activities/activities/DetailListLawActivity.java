package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.traficapplication.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailListLawActivity extends AppCompatActivity {

    private TextView tvItemLawTittle;
    private TextView tvItemLawDetail;
    private TextView tvItemLawContent;
    private CircleImageView cImgItemLaw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_law);
        initUi();
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            String itemLawTittle = (String) b.get("tittle");
            tvItemLawTittle.setText(itemLawTittle);
            String itemLawDetail = (String) b.get("detail");
            tvItemLawDetail.setText(itemLawDetail);
            int img = (int) b.get("img");
            cImgItemLaw.setImageResource(img);
            String itemLawContent =(String) b.get("content");
            tvItemLawContent.setText(itemLawContent);
        }
    }

    private void initUi() {
        tvItemLawTittle = findViewById(R.id.tv_tittle_item_law);
        cImgItemLaw = findViewById(R.id.img_item_law);
        tvItemLawContent = findViewById(R.id.tv_content_item_law);
        tvItemLawDetail = findViewById(R.id.tv_detail_item_law);
    }
}