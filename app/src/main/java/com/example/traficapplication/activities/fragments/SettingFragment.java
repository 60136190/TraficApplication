package com.example.traficapplication.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.traficapplication.R;

public class SettingFragment extends Fragment {
    private View settingView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingView = inflater.inflate(R.layout.setting_fragment, container, false);

       return settingView;
    }




}
