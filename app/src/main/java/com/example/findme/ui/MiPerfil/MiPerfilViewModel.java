package com.example.findme.ui.MiPerfil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MiPerfilViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MiPerfilViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Mi Perfil fragment");
    }

    public LiveData<String> getText() {
        return mText;}

}
