package com.example.traficapplication.activities.sliders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.MainActivity;
import com.example.traficapplication.activities.adapters.SliderAdapter;
import com.example.traficapplication.activities.auth.LoginActivity;

public class SlideActivity extends AppCompatActivity {

    private ViewPager mSlideviewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private Button mNext;
    private int mCurrentPage;
    private TextView skip;
    private SliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        initUi();
        sliderAdapter = new SliderAdapter(this);
        mSlideviewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mSlideviewPager.addOnPageChangeListener(viewListener);
        mNext.setVisibility(View.INVISIBLE);


        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSlideviewPager.setCurrentItem(mCurrentPage + 1);
                String fi = mNext.getText().toString();
                if( mNext.isClickable()){

                    Intent intent4 = new Intent(SlideActivity.this, MainActivity.class);
                    startActivity(intent4);
                    finish();

                }
            }
        });

    }

    public void initUi(){
        mSlideviewPager = (ViewPager)findViewById(R.id.slide_viewpager);
        mDotLayout = (LinearLayout) findViewById(R.id.dot_indicator);
        mNext = findViewById(R.id.btn_done);

//        skip = findViewById(R.id.tv_skip);
    }
    public void addDotsIndicator(int position){
        mDots = new TextView[4];
        mDotLayout.removeAllViews();
        for (int i = 0 ;i < mDots.length;i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.grey));
            mDotLayout.addView(mDots[i]);
        }
        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;
            if(i == 0){
                mNext.setVisibility(View.INVISIBLE);

            }else if(i == mDots.length -1){
                mNext.setEnabled(true);
                mNext.setVisibility(View.VISIBLE);
                mNext.setText("Finish");

            }else {
                mNext.setVisibility(View.INVISIBLE);

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}