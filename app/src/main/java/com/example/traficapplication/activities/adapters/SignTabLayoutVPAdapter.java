package com.example.traficapplication.activities.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.traficapplication.activities.fragments.SignAuxiliaryFragment;
import com.example.traficapplication.activities.fragments.SignCommandFragment;
import com.example.traficapplication.activities.fragments.SignGuideFragment;
import com.example.traficapplication.activities.fragments.SignProhibitFragment;
import com.example.traficapplication.activities.fragments.SignWarningFragment;

public class SignTabLayoutVPAdapter extends FragmentStatePagerAdapter {


    public SignTabLayoutVPAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new SignProhibitFragment();
            case 1:
                return new SignCommandFragment();
            case 2:
                return new SignGuideFragment();
            case 3:
                return new SignWarningFragment();
            case 4:
                return new SignAuxiliaryFragment();
            default:
                return new SignProhibitFragment();
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
