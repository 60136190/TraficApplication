package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.ItemLawAdapter;
import com.example.traficapplication.activities.adapters.SignalAdapter;
import com.example.traficapplication.activities.adapters.TabLayoutVPSingalAdapter;
import com.example.traficapplication.activities.models.ItemLaw;
import com.example.traficapplication.activities.models.Signal;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListLawActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemLawAdapter itemLawAdapter;
    private ArrayList<ItemLaw> itemLaw = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_law);
        initUi();
        setRecylerView();

    }



    private void defineAdapter() {
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b.get("detail").equals("Xe may")) {
            itemAdd(R.drawable.img,"abc","cccccccc","cascas");
        }
        else {
            if (b.get("detail").equals("Xe hơi")) {
                itemAdd(R.drawable.img_2,"abc","cccccccc","cascas");
            }
            else{
                itemAdd(R.drawable.img_3,"abc","cccccccc","cascas");
            }
        }
    }

    private void setRecylerView() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        itemLawAdapter = new ItemLawAdapter(this,itemLaw);
        recyclerView.setAdapter(itemLawAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        defineAdapter();
        itemLawAdapter.notifyDataSetChanged();
    }

    private void initUi() {
        recyclerView = findViewById(R.id.rv_list_law);
    }
    private void itemAdd(int img, String tittle, String content, String detail){
        itemLaw.add(new ItemLaw(img,tittle,content,detail));
    }
}