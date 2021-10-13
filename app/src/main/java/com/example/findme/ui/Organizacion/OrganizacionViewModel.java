package com.example.findme.ui.Organizacion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrganizacionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OrganizacionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is organizacion fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}