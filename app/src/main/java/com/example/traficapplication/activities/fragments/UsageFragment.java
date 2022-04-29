package com.example.traficapplication.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.traficapplication.activities.models.SettingViewModel;
import com.example.traficapplication.activities.models.UsageViewModel;
import com.example.traficapplication.databinding.SettingFragmentBinding;
import com.example.traficapplication.databinding.UsageFragmentBinding;

public class UsageFragment extends Fragment {
    private UsageFragmentBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UsageViewModel usageViewModel = new ViewModelProvider(this).get(UsageViewModel.class);

        binding = UsageFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textUsage;
        usageViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
