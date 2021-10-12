package com.example.findme.ui.Estadisticas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EstadisticasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EstadisticasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Estadisticas fragment");
    }

    public LiveData<String> getText() {
        return mText;}

}
