package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.TabLayoutVPSingalAdapter;
import com.google.android.material.tabs.TabLayout;

public class SignalActivity extends AppCompatActivity {

    private TabLayout tabLayoutSignal;
    private ViewPager viewPagerSignal;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signal);
        initUi();
        TabLayoutVPSingalAdapter adapterSignal = new TabLayoutVPSingalAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerSignal.setAdapter(adapterSignal);
        tabLayoutSignal.setupWithViewPager(viewPagerSignal);
    }

    private void initUi() {
        tabLayoutSignal =  findViewById(R.id.tab_layout_signal);
        viewPagerSignal =  findViewById(R.id.view_pager_signal);
    }
}
