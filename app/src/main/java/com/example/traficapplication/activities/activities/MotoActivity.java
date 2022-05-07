package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.ItemLawAdapter;
import com.example.traficapplication.activities.models.ItemLaw;

import java.util.ArrayList;

public class MotoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemLawAdapter itemLawAdapter;
    private ArrayList<ItemLaw> itemLaw = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moto);
        initUi();
        setRecylerView();

    }



    private void defineAdapter() {
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b.get("lawPos").equals("0")) {
            itemAdd(R.drawable.img,"abc","cccccccc","cascas");
        }
        if (b.get("lawPos").equals("1")) {
            itemAdd(R.drawable.img_2,"abc","cccccccc","cascas");
        }
        if (b.get("lawPos").equals("3")){
            itemAdd(R.drawable.img_3,"abc","cccccccc","cascas");
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
        recyclerView = findViewById(R.id.rv_list_moto_law);
    }
    private void itemAdd(int img, String tittle, String content, String detail){
        itemLaw.add(new ItemLaw(img,tittle,content,detail));
    }
}