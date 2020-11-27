package com.dev_computing.covidintokpisin.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;
//    private MutableLiveData<String>sText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("ringim covid-19 hotline nau yet");

    }

    public LiveData<String> getText() {

        return mText;

    }
}