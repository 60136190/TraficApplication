package com.example.traficapplication.activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.traficapplication.R;
import com.example.traficapplication.activities.adapters.LawTabLayoutVPAdapter;
import com.google.android.material.tabs.TabLayout;

public class LawActivity extends AppCompatActivity {
    private TabLayout tabLayoutLaw;
    private ViewPager viewPagerLaw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law);
        initUi();
        LawTabLayoutVPAdapter adapterLaw = new LawTabLayoutVPAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerLaw.setAdapter(adapterLaw);
        tabLayoutLaw.setupWithViewPager(viewPagerLaw);
    }
    private void initUi() {
        tabLayoutLaw =  findViewById(R.id.tab_layout_law);
        viewPagerLaw =  findViewById(R.id.view_pager_law);
    }
}