package com.example.findme.ui.CerrarS;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CerrarSViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public CerrarSViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is CerrarSesion fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
