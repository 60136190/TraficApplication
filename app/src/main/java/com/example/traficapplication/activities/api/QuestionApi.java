package com.example.traficapplication.activities.api;

import com.example.traficapplication.activities.models.QuestionAllResponse;
import com.example.traficapplication.activities.models.QuestionCategoryAllResponse;
import com.example.traficapplication.activities.models.QuestionCategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface QuestionApi {
    @GET("categoryLearn/getAll")
    Call<QuestionCategoryAllResponse> getAllQuestionCategories();
    @GET("learn/getLearnFollowIdCategory/{id}")
    Call<QuestionCategoryResponse> getChapter(@Path("id") String id);
//    @GET("learn/getAll")
//    Call<QuestionAllResponse> getAllQuestion();

}
