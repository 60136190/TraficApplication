package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.TestAdapter;
import com.example.traficapplication.activities.models.Test;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    private Button start,result;
    private RecyclerView recyclerView;
    private TestAdapter testAdapter;
    private ArrayList<Test> tests = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initUi();
       startTest();
       showResult();
//        setRecylerView();
    }

    private void showResult() {
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this, TestResultActivity.class);
                intent.putExtra("act","testAct");
                startActivity(intent);
            }
        });
    }

    private void startTest() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this, TestDoingActivity.class);
                startActivity(intent);
            }
        });

    }


//    private void setRecylerView() {
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        testAdapter = new TestAdapter(this, tests);
//        recyclerView.setAdapter(testAdapter);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
//        recyclerView.addItemDecoration(dividerItemDecoration);
//        itemAdd("Đề số 1");
//        itemAdd(" Đề số 2");
//        itemAdd("Đề số 3");
//        itemAdd("Đề số 4");
//        itemAdd("Đề số 5");
//        itemAdd("Đề số 6");
//        itemAdd("Đề số 7");
//        itemAdd("Đề số 8");
//        itemAdd("Đề số 9");
//        itemAdd("Đề số 10");
//        itemAdd("Đề số 11");
//        itemAdd("Đề số 12");
//        itemAdd("Đề số 13");
//        itemAdd("Đề số 14");
//        itemAdd("Đề số 15");
//        itemAdd("Đề số 16");
//        itemAdd("Đề số 17");
//        itemAdd("Đề số 18");
//
//        testAdapter.notifyDataSetChanged();
//
//    }

    private void initUi() {
//        recyclerView = findViewById(R.id.rv_test);
        start = findViewById(R.id.btn_test_start);
        result = findViewById(R.id.btn_test_result);

    }
    private void itemAdd( String tittle){
        tests.add(new Test(tittle));
    }
}