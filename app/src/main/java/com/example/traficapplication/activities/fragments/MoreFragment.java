package com.example.traficapplication.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.traficapplication.R;

public class MoreFragment extends Fragment {
    private View settingView;
    private TextView tv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingView = inflater.inflate(R.layout.fragment_more, container, false);
        initUi();
        setText();
       return settingView;
    }

    private void setText() {
        tv.setText("Ứng dụng được thiết kế bởi" +
                "\n-Sinh viên: Hồ Đại Phương" +
                "\n-MSSV: 60136586" +
                "\n-Mail: phuong.hd.60cntt@ntu.edu.vn");
    }


    private void initUi() {
        tv = settingView.findViewById(R.id.text_setting);
    }



}
