package com.example.findme.ui.PersonasE;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonasEViewModel extends ViewModel {
        private MutableLiveData<String> mText;

        public PersonasEViewModel() {
            mText = new MutableLiveData<>();
            mText.setValue("This is Personas Encontradas fragment");
        }

        public LiveData<String> getText() {
            return mText;
        }
}