package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.QuestionLearnAdapter;
import com.example.traficapplication.activities.api.ApiClient;
import com.example.traficapplication.activities.models.QuestionCategoryResponse;
import com.example.traficapplication.activities.utils.Contants;
import com.example.traficapplication.activities.utils.StoreUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private QuestionLearnAdapter questionLearnAdapter;
    private Button btnPrevious;
    private Button btnNext;
    private TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        initUi();
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        String id = (String) b.get("id");
        getData(id);

        mRecyclerView = findViewById(R.id.rcv_question);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int position = getCurrentItem();
                tvCount.setText("Question\n"+"" + (position+1) + " / " + questionLearnAdapter.getItemCount());
            }
        });

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview();
            }
        });

        //Onlick đến câu hỏi
        tvCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog(Gravity.BOTTOM);

            }
        });
        oldPos();
    }

    private void initUi() {
        btnPrevious = findViewById(R.id.btn_previous);
        btnNext = findViewById(R.id.btn_next);
        tvCount = findViewById(R.id.tv_count);
    }

    public void preview() {
        int position = getCurrentItem();
        if (position > 0)
            setCurrentItem(position - 1, true);
    }

    public void next() {
        RecyclerView.Adapter adapter = mRecyclerView.getAdapter();
        if (adapter == null)
            return;

        int position = getCurrentItem();
        int count = adapter.getItemCount();
        if (position < (count - 1))
            setCurrentItem(position + 1, true);
    }
    ///Dialog tìm câu hỏi
    public void dialog(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_question);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAtribute = window.getAttributes();
        window.setAttributes(windowAtribute);
        ImageView imgGo = dialog.findViewById(R.id.btn_go);
        EditText edtPage = dialog.findViewById(R.id.edt_page_go);
        TextView tvPage = dialog.findViewById(R.id.tv_page);
        RecyclerView.Adapter adapter = mRecyclerView.getAdapter();
        tvPage.setText("/ "+ String.valueOf(adapter.getItemCount()));
        imgGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adapter == null)
                    return;
                String edt = String.valueOf(edtPage.getText());
                String n = "";
                int count = adapter.getItemCount();
                if (edt.equals(n))
                {
                    notInsert();
                }
                else {
                    int position =Integer.parseInt(edt);
                    if (position < (count))
                    {
                        if (position>0)
                        {
                            setCurrentItem(position-1, false);
                            dialog.dismiss();
                        }
                        else notInsert();

                    }
                    else {
                        position = count;
                        setCurrentItem(position-1,false);
                        dialog.dismiss();
                        Toast.makeText(QuestionActivity.this,count +" là câu cuối rồi",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        dialog.show();

    }
    private void notInsert(){
        Toast.makeText(QuestionActivity.this,"Chưa chọn câu cần đến",Toast.LENGTH_SHORT).show();
    }
    //// Mở lại câu cũ
    public void oldPos(){
        String pos = getSharedPreferences("MySharedPref",Context.MODE_PRIVATE).getString(Contants.position,"");
        SharedPreferences sharedPreferences = QuestionActivity.this.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        if (sharedPreferences.getString(Contants.position, "").isEmpty()){
        }else{
            setCurrentItem(Integer.parseInt(pos),false);
        }
    }
////Bấm thoát lưu vị trí câu
    @Override
    public void onBackPressed() {
        RecyclerView.Adapter adapter = mRecyclerView.getAdapter();
        if (adapter == null)
            return;
        int position = getCurrentItem();
        StoreUtils.save(QuestionActivity.this, Contants.position, String.valueOf(position));
        QuestionActivity.this.finish();

    }
    private int getCurrentItem() {
        return ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                .findFirstVisibleItemPosition();
    }

    private void setCurrentItem(int position, boolean smooth) {
        if (smooth)
            mRecyclerView.smoothScrollToPosition(position);
        else
            mRecyclerView.scrollToPosition(position);
    }
/////Lấy câu hỏi
    private void getData(String id) {
        Call<QuestionCategoryResponse> responseDTOCall = (Call<QuestionCategoryResponse>) ApiClient.questionApi().getChapter(id);
        responseDTOCall.enqueue(new Callback<QuestionCategoryResponse>() {
            @Override
            public void onResponse(Call<QuestionCategoryResponse> call, Response<QuestionCategoryResponse> response) {
                questionLearnAdapter = new QuestionLearnAdapter(QuestionActivity.this,response.body().getData());
                mRecyclerView.setAdapter(questionLearnAdapter);
            }
            @Override
            public void onFailure(Call<QuestionCategoryResponse> call, Throwable t) {
                Toast.makeText(QuestionActivity.this, "Connecting... ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}