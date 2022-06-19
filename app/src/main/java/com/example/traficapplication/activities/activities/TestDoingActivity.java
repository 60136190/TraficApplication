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
import android.os.CountDownTimer;
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
import com.example.traficapplication.activities.adapters.QuestionTestAdapter;
import com.example.traficapplication.activities.api.ApiClient;
import com.example.traficapplication.activities.models.QuestionCategoryResponse;
import com.example.traficapplication.activities.utils.Contants;
import com.example.traficapplication.activities.utils.StoreUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestDoingActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private QuestionTestAdapter questionLearnAdapter;
    private Button btnPrevious;
    private Button btnNext;
    private TextView tvCount,tvTime;
    private long backPressTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_doing);
        initUi();
        getData();
        makeRecyclerView();
        time();
        showResult();

    }

    private void checkAnswer() {

    }


    private void showResult() {
        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogResult(Gravity.BOTTOM);
            }
        });
    }

    private void time() {
        int durraton = 1500000;
        CountDownTimer Timer = new CountDownTimer(durraton, 1000) {
            public void onTick(long millisUntilFinished) {
                tvTime.setText("Thời gian còn lại: " +millisUntilFinished/60000 +":"+ (millisUntilFinished-(millisUntilFinished/60000)*60000)/1000 +"\nNhấn vào đây để nộp bài.");
            }

            public void onFinish() {
                tvTime.setText("Hết giờ");
                result();
            }
        }.start();
    }

    private void result() {
        Intent intent = new Intent(TestDoingActivity.this, TestResultActivity.class);
        startActivity(intent);
        TestDoingActivity.this.finish();
    }

    private void makeRecyclerView() {
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
                dialogSearch(Gravity.BOTTOM);
            }
        });
        oldPos();
    }


    @Override
    public void onBackPressed() {
        dialogBack(Gravity.BOTTOM);

}

    private void dialogResult(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_test_back);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtribute = window.getAttributes();
        window.setAttributes(windowAtribute);

        // show dialog
        Button btnYes = dialog.findViewById(R.id.btn_continue_test);
        Button btnNo = dialog.findViewById(R.id.btn_exit_test);
        TextView tvWarning = dialog.findViewById(R.id.tv_warning);
        btnYes.setText("Vâng");
        btnNo.setText("Không");
        tvWarning.setText("Bạn chắc chứ? Khi nộp bài bạn sẽ không được sửa đổi nữa.");
        TextView tvTestTittle = dialog.findViewById(R.id.tv_testing);
        tvTestTittle.setText("Nộp bài thi ?");
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result();
                dialog.dismiss();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void dialogBack(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_test_back);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtribute = window.getAttributes();
        window.setAttributes(windowAtribute);

        // show dialog
        Button btnSave = dialog.findViewById(R.id.btn_continue_test);
        Button btnExit = dialog.findViewById(R.id.btn_exit_test);
        TextView tvTestTittle = dialog.findViewById(R.id.tv_testing);
        tvTestTittle.setText("Đề thi ngẫu nhiên hạng A1");
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView.Adapter adapter = mRecyclerView.getAdapter();
                if (adapter == null)
                    return;
                int position = getCurrentItem();
                StoreUtils.save(TestDoingActivity.this, Contants.position, String.valueOf(position));
                dialog.dismiss();
                TestDoingActivity.this.finish();

            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestDoingActivity.this.finish();
                SharedPreferences email = TestDoingActivity.this.getSharedPreferences("MySharedPref", 0);
                email.edit().remove("position").commit();
                TestDoingActivity.this.finish();
            }
        });
        dialog.show();
    }
    public boolean hasPreview() {
        return getCurrentItem() > 0;
    }

    public boolean hasNext() {
        return mRecyclerView.getAdapter() != null &&
                getCurrentItem() < (mRecyclerView.getAdapter().getItemCount() - 1);
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
    public void dialogSearch(int gravity){
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
                        Toast.makeText(TestDoingActivity.this,count +" là câu cuối rồi",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        dialog.show();
    }
    private void notInsert(){
        Toast.makeText(TestDoingActivity.this,"Chưa chọn câu cần đến",Toast.LENGTH_SHORT).show();
    }
    //// Mở lại câu cũ
    public void oldPos(){
        String pos = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE).getString(Contants.position,"");
        SharedPreferences sharedPreferences = TestDoingActivity.this.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        if (sharedPreferences.getString(Contants.position, "").isEmpty()){
        }else{
            setCurrentItem(Integer.parseInt(pos),false);
        }
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
    private void getData() {
        Call<QuestionCategoryResponse> responseDTOCall = (Call<QuestionCategoryResponse>) ApiClient.questionApi().getChapter("629c40d5d25db7c7fe473471");
        responseDTOCall.enqueue(new Callback<QuestionCategoryResponse>() {
            @Override
            public void onResponse(Call<QuestionCategoryResponse> call, Response<QuestionCategoryResponse> response) {
                questionLearnAdapter = new QuestionTestAdapter(TestDoingActivity.this,response.body().getData());
                mRecyclerView.setAdapter(questionLearnAdapter);
            }
            @Override
            public void onFailure(Call<QuestionCategoryResponse> call, Throwable t) {
                Toast.makeText(TestDoingActivity.this, "Connecting... ", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initUi() {
        mRecyclerView = findViewById(R.id.rcv_question_test);
        btnPrevious = findViewById(R.id.btn_prev_test);
        btnNext = findViewById(R.id.btn_next_test);
        tvCount = findViewById(R.id.tv_count_test);
        tvTime = findViewById(R.id.tv_time_remain);
    }


}