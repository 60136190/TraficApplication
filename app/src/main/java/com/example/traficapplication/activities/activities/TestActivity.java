package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.traficapplication.activities.MainActivity;
import com.example.traficapplication.activities.adapters.TestAdapter;
import com.example.traficapplication.activities.auth.LoginActivity;
import com.example.traficapplication.activities.auth.RegisterActivity;
import com.example.traficapplication.activities.auth.UserActivity;
import com.example.traficapplication.activities.models.Test;
import com.example.traficapplication.activities.utils.Contants;

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
    }

    private void showResult() {
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = TestActivity.this.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                if (sharedPreferences.getString(Contants.email, "").isEmpty()){
                    openDialog(Gravity.BOTTOM);
                }else{
                    Intent intent = new Intent(TestActivity.this, TestResultActivity.class);
                    intent.putExtra("act","testAct");
                    startActivity(intent);
                }

            }
        });
    }

    private void startTest() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = TestActivity.this.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                if (sharedPreferences.getString(Contants.email, "").isEmpty()){
                    openDialog(Gravity.BOTTOM);
                }else{
                    Intent intent = new Intent(TestActivity.this, TestDoingActivity.class);
                    startActivity(intent);
                }

            }
        });

    }



    private void openDialog(int gravity){

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_user_back);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtribute = window.getAttributes();
        window.setAttributes(windowAtribute);

        TextView tvMessage = dialog.findViewById(R.id.tv_warning_user);
        Button btnLogin = dialog.findViewById(R.id.btn_back_user);
        Button btnCreate = dialog.findViewById(R.id.btn_exit_user);
        btnLogin.setText(R.string.Login);
        btnCreate.setText(R.string.Create);
        tvMessage.setText(R.string.not_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, LoginActivity.class);
                startActivity(intent);
                TestActivity.this.finish();

            }
        });
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, RegisterActivity.class);
                startActivity(intent);
               TestActivity.this.finish();

            }
        });
        dialog.show();
    }
    private void initUi() {
        start = findViewById(R.id.btn_test_start);
        result = findViewById(R.id.btn_test_result);

    }
    private void itemAdd( String tittle){
        tests.add(new Test(tittle));
    }
}