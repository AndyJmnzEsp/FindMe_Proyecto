package com.example.findme.ui.SeguimientoMP;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SeguimientoMPViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public SeguimientoMPViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Seguimiento MP fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
