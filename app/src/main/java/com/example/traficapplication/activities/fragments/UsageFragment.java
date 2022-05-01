package com.example.traficapplication.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.traficapplication.R;

public class UsageFragment extends Fragment {
    private View usageView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        usageView = inflater.inflate(R.layout.fragment_usage, container, false);
       return usageView;
    }


}
