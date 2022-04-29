package com.example.traficapplication.activities.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UsageViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public UsageViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is usage fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
