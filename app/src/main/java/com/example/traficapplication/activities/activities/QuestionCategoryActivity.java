package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.QuestionCategoryAdapter;
import com.example.traficapplication.activities.api.ApiClient;
import com.example.traficapplication.activities.models.QuestionCategory;
import com.example.traficapplication.activities.models.QuestionCategoryAllResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionCategoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private QuestionCategoryAdapter questionCategoryAdapter;
    private List<QuestionCategory> questionCategories = new ArrayList<>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_category);
        initUi();
        getCategory();
        setRecylerView();
    }
    private void setRecylerView() {
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(QuestionCategoryActivity.this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        questionCategoryAdapter = new QuestionCategoryAdapter(questionCategories, QuestionCategoryActivity.this);
    }
    private void getCategory() {
        Call<QuestionCategoryAllResponse> responseDTOCall = (Call<QuestionCategoryAllResponse>) ApiClient.questionApi().getAllQuestionCategories();
        responseDTOCall.enqueue(new Callback<QuestionCategoryAllResponse>() {
            @Override
            public void onResponse(Call<QuestionCategoryAllResponse> call, Response<QuestionCategoryAllResponse> response) {
                questionCategories.addAll(response.body().getData());
                recyclerView.setAdapter(questionCategoryAdapter);
            }
            @Override
            public void onFailure(Call<QuestionCategoryAllResponse> call, Throwable t) {
                Toast.makeText(QuestionCategoryActivity.this, "Connecting... ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUi() {
        recyclerView = findViewById(R.id.rv_document);
    }

}