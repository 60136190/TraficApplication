package com.example.traficapplication.activities.activities;

import static com.example.traficapplication.activities.utils.Contants.listId;
import static com.example.traficapplication.activities.utils.Contants.listMarks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.ResultAdapter;
import com.example.traficapplication.activities.utils.StoreUtils;

import java.util.ArrayList;
import java.util.List;

public class TestResultActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private ResultAdapter resultAdapter;
    private TextView tvResult;
    private int mark = listId.size();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);
        initUI();
        addResult();
        getAct();

    }

    private void getAct() {

        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            if (b.get("act").equals("testAct"))
            {
                tvResult.setVisibility(View.GONE);
            }
        }
        else {
            dialogResult(Gravity.BOTTOM);
            result();
        }

    }


    private void dialogResult(int gravity){
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_result);
            Window window = dialog.getWindow();
            if (window == null) {
                return;
            }
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            WindowManager.LayoutParams windowAtribute = window.getAttributes();
            window.setAttributes(windowAtribute);
            // show dialog
            TextView tvWarning = dialog.findViewById(R.id.tv_dialog_warning);
            if (mark<21){
                tvWarning.setText("Thế là chưa đạt rồi!");
            }
            else {
                tvWarning.setText("Tốt! đạt rồi nhé!");
            }
            Button btnOK = dialog.findViewById(R.id.btn_ok);
            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }


    private void addResult() {
        linearLayoutManager = new LinearLayoutManager(TestResultActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        resultAdapter = new ResultAdapter(TestResultActivity.this,listMarks);
        recyclerView.setAdapter(resultAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void result() {
        listMarks.add(String.valueOf(mark));
        tvResult.setText(String.valueOf(mark));
        StoreUtils.writeListInPref(TestResultActivity.this,listMarks,"ListMarks");
        listId.removeAll(listId);
    }



    private void initUI() {
        tvResult = findViewById(R.id.tv_result);
        recyclerView = findViewById(R.id.result);
    }
}