package com.example.traficapplication.activities.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.traficapplication.activities.fragments.AuxiliarySignalFragment;
import com.example.traficapplication.activities.fragments.CommandSignalFragment;
import com.example.traficapplication.activities.fragments.GuideSignalFragment;
import com.example.traficapplication.activities.fragments.ProhibitSignalFragment;
import com.example.traficapplication.activities.fragments.WarningSignalFragment;

public class TabLayoutVPSingalAdapter extends FragmentStatePagerAdapter {


    public TabLayoutVPSingalAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new ProhibitSignalFragment();
            case 1:
                return new CommandSignalFragment();
            case 2:
                return new GuideSignalFragment();
            case 3:
                return new WarningSignalFragment();
            case 4:
                return new AuxiliarySignalFragment();
            default:
                return new ProhibitSignalFragment();
        }

    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title ="";
        switch (position) {
            case 0:
                return title="Biển cấm";
            case 1:
                return title="Biển hiệu lệnh";
            case 2:
                return title="Biển chỉ dẫn";
            case 3:
                return title="Biển cảnh báo và nguy hiểm";
            case 4:
                return title="Biển phụ";
            default:
                return title="Biển cấm";

        }
    }
}
