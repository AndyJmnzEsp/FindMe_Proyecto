package com.example.findme.ui.Muro;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MuroViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MuroViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Muro fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
