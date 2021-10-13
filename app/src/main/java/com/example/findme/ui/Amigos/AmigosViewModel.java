package com.example.findme.ui.Amigos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AmigosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AmigosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is amigos fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
