package com.example.tcpland.ui.Fragments.Home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UntitleViewMode extends ViewModel {

    private final MutableLiveData<String> mText;

    public UntitleViewMode() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}