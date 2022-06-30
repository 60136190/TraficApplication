package com.example.traficapplication.activities.activities;

import static com.example.traficapplication.activities.utils.Contants.listId;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
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
import android.widget.Toast;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.TestHistoryAdapter;
import com.example.traficapplication.activities.api.ApiClient;
import com.example.traficapplication.activities.models.History;
import com.example.traficapplication.activities.models.ResponseDTO;
import com.example.traficapplication.activities.models.TestHistory;
import com.example.traficapplication.activities.models.TestHistoryResponse;
import com.example.traficapplication.activities.utils.Contants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestResultActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private TextView tvResult;
    private Button btnSave;
    private int mark = listId.size();
    private TestHistoryAdapter testHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_history);
        initUI();
        getAct();
        callHistory();
        linearLayoutManager = new LinearLayoutManager(TestResultActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }



    private void getAct() {
        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            if (b.get("act").equals("testAct"))
            {
                tvResult.setVisibility(View.GONE);
                btnSave.setVisibility(View.GONE);
            }
        }
        else {
            dialogResult(Gravity.BOTTOM);
            result();
        }
    }
    private void callHistory() {
        Call<TestHistoryResponse> responseDTOCall = (Call<TestHistoryResponse>) ApiClient.historyApi().getHistory();
        responseDTOCall.enqueue(new Callback<TestHistoryResponse>() {
            @Override
            public void onResponse(Call<TestHistoryResponse> call, Response<TestHistoryResponse> response) {
                testHistoryAdapter = new TestHistoryAdapter(TestResultActivity.this,response.body().getData());
                recyclerView.setAdapter(testHistoryAdapter);
            }
            @Override
            public void onFailure(Call<TestHistoryResponse> call, Throwable t) {
                Toast.makeText(TestResultActivity.this, "Connecting... ", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void result() {
        tvResult.setText(String.valueOf(mark+"/25"));
        listId.removeAll(listId);
        pushResult(String.valueOf(mark));
    }

    private void pushResult(String mark) {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = TestResultActivity.this.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                String id = sharedPreferences.getString(Contants.id, "");
                History history = new History(mark,id);
                Call<ResponseDTO> responseDTOCall = (Call<ResponseDTO>) ApiClient.historyApi().saveHistory(history);
                responseDTOCall.enqueue(new Callback<ResponseDTO>() {
                    @Override
                    public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                        if (response.body().getStatus()==200)
                        {
                            Toast.makeText(TestResultActivity.this,"Điểm đã được cập nhất lên hệ thống",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(TestResultActivity.this,"Điểm chưa được cập nhất lên hệ thống",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseDTO> call, Throwable t) {
                        Toast.makeText(TestResultActivity.this,"Connecting...",Toast.LENGTH_SHORT).show();
                    }

                });
            }
        });

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


    private void initUI() {
        btnSave = findViewById(R.id.btn_save_result);
        tvResult = findViewById(R.id.tv_result);
        recyclerView = findViewById(R.id.result);
    }

}