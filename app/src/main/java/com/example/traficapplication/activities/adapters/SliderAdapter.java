package com.example.traficapplication.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.traficapplication.R;

public class SliderAdapter extends PagerAdapter {
    private Context sliderContext;
    private LayoutInflater layoutInflater;

    public SliderAdapter(Context sliderContext) {
        this.sliderContext = sliderContext;
    }

    public int[] slide_image ={
            R.drawable.img,
            R.drawable.img_5,
            R.drawable.img_4,
            R.drawable.img_3

    };
    public String[] slide_tittle ={
            "a","b","c","d"
    };
    public String[] slide_detail ={
            "e","f","g","h"
    };
    @Override
    public int getCount() {
        return slide_tittle.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) sliderContext.getSystemService(sliderContext.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider, (ViewGroup) container,false);
        ImageView slideImageView = view.findViewById(R.id.slide_img);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView slideDescs = view.findViewById(R.id.slide_descs);

        slideImageView.setBackgroundResource(slide_image[position]);
        slideHeading.setText(slide_tittle[position]);
        slideDescs.setText(slide_detail[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
