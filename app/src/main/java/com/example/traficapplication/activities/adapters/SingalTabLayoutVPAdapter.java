package com.example.traficapplication.activities.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.traficapplication.activities.fragments.SignalAuxiliaryFragment;
import com.example.traficapplication.activities.fragments.SignalCommandFragment;
import com.example.traficapplication.activities.fragments.SignalGuideFragment;
import com.example.traficapplication.activities.fragments.SignalProhibitFragment;
import com.example.traficapplication.activities.fragments.SignalWarningFragment;

public class SingalTabLayoutVPAdapter extends FragmentStatePagerAdapter {


    public SingalTabLayoutVPAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new SignalProhibitFragment();
            case 1:
                return new SignalCommandFragment();
            case 2:
                return new SignalGuideFragment();
            case 3:
                return new SignalWarningFragment();
            case 4:
                return new SignalAuxiliaryFragment();
            default:
                return new SignalProhibitFragment();
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
