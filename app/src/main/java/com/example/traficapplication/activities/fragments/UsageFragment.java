package com.example.traficapplication.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.traficapplication.R;

public class UsageFragment extends Fragment {
    private View usageView;
    private TextView tv;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        usageView = inflater.inflate(R.layout.fragment_usage, container, false);
        initUi();
        setText();
       return usageView;

    }

    private void setText() {
        tv.setText("- Để sử dụng các chức năng liên quan đến điểm thi người sử dụng cần có tài khoản." +
                "\n- Tài khoản có thể được đăng kí bằng bất kì email nào chưa trùng trên hệ thống." +
                "\n- Thông tin người dùng chỉ được sử dụng nhằm mục đích lưu trữ thông tin và không nhằm mục đích nào khác.");
    }


    private void initUi() {
        tv = usageView.findViewById(R.id.text_note);
    }


}
