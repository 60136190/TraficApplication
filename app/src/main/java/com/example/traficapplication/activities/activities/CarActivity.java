package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.LawAdapter;
import com.example.traficapplication.activities.models.Law;

import java.util.ArrayList;

public class CarActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LawAdapter lawAdapter;
    private ArrayList<Law> law = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
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
        if (b.get("lawPos").equals("2")){
                itemAdd(R.drawable.img_3,"abc","cccccccc","cascas");
            }

    }


    private void setRecylerView() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        lawAdapter = new LawAdapter(this, law);
        recyclerView.setAdapter(lawAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        defineAdapter();
        lawAdapter.notifyDataSetChanged();
    }

    private void initUi() {
        recyclerView = findViewById(R.id.rv_list_car_law);
    }
    private void itemAdd(int img, String tittle, String content, String detail){
        law.add(new Law(img,tittle,content,detail));
    }


}