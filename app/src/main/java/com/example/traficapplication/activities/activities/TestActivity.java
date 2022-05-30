package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.DocumentAdapter;
import com.example.traficapplication.activities.adapters.TestAdapter;
import com.example.traficapplication.activities.models.Document;
import com.example.traficapplication.activities.models.Test;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TestAdapter testAdapter;
    private ArrayList<Test> tests = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initUi();
        setRecylerView();
    }

    private void setRecylerView() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        testAdapter = new TestAdapter(this, tests);
        recyclerView.setAdapter(testAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        itemAdd("Đề số 1");
        itemAdd(" Đề số 2");
        itemAdd("Đề số 3");
        itemAdd("Đề số 4");
        itemAdd("Đề số 5");
        itemAdd("Đề số 6");
        itemAdd("Đề số 7");
        itemAdd("Đề số 8");
        itemAdd("Đề số 9");
        itemAdd("Đề số 10");
        itemAdd("Đề số 11");
        itemAdd("Đề số 12");
        itemAdd("Đề số 13");
        itemAdd("Đề số 14");
        itemAdd("Đề số 15");
        itemAdd("Đề số 16");
        itemAdd("Đề số 17");
        itemAdd("Đề số 18");

        testAdapter.notifyDataSetChanged();

    }

    private void initUi() {
        recyclerView = findViewById(R.id.rv_test);
    }
    private void itemAdd( String tittle){
        tests.add(new Test(tittle));
    }
}