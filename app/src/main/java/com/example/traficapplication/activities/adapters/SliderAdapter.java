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

import de.hdodenhof.circleimageview.CircleImageView;

public class SliderAdapter extends PagerAdapter {
    private Context sliderContext;
    private LayoutInflater layoutInflater;

    public SliderAdapter(Context sliderContext) {
        this.sliderContext = sliderContext;
    }

    public int[] slide_image ={
            R.drawable.racing,
            R.drawable.car1,
            R.drawable.traffic_signal,
            R.drawable.accident

    };
    public String[] slide_tittle ={
            "Xin chào","Ứng dụng cung cấp","Ngoài ra còn có","Chúc bạn may mắn"
    };
    public String[] slide_detail ={
            "Cảm ơn đã cài đặt ứng dụng",
            "Các câu hỏi, tài liệu ôn thi",
            "Thông tin về luật, tín hiệu giao thông",
            "Đạt kết quả cao trong bài sát hạch và hơn hết là điều khiển phương tiện an toàn nhé"
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
        CircleImageView slideImageView = view.findViewById(R.id.slide_img);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView slideDescs = view.findViewById(R.id.slide_descs);

        slideImageView.setImageResource(slide_image[position]);
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
