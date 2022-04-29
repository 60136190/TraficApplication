package com.example.traficapplication.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.traficapplication.activities.models.HomeViewModel;
import com.example.traficapplication.activities.models.SettingViewModel;
import com.example.traficapplication.databinding.HomeFragmentBinding;
import com.example.traficapplication.databinding.SettingFragmentBinding;

public class SettingFragment extends Fragment {
    private SettingFragmentBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingViewModel settingViewModel = new ViewModelProvider(this).get(SettingViewModel.class);

        binding = SettingFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSetting;
        settingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
