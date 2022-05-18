package com.example.traficapplication.activities.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.traficapplication.activities.fragments.CarFragment;
import com.example.traficapplication.activities.fragments.MotoFragment;
import com.example.traficapplication.activities.fragments.OtherFragment;

public class LawTabLayoutVPAdapter extends FragmentStatePagerAdapter {

    public LawTabLayoutVPAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MotoFragment();
            case 1:
                return new CarFragment();
            case 2:
                return new OtherFragment();
            default:
                return new MotoFragment();
        }
    }
    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title ="";
        switch (position) {
            case 0:
                return title="Xe máy";
            case 1:
                return title="Xe hơi";
            case 2:
                return title="Khác";
            default:
                return title="Xe máy";

        }
    }
}
