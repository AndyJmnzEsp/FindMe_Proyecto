package com.example.findme.ui.Buzon;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BuzonViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BuzonViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Buzon fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}