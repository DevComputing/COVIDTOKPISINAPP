package com.dev_computing.covidintokpisin.ui.slideshow;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dev_computing.covidintokpisin.ListItem;
import com.dev_computing.covidintokpisin.ListItemRepository;
//import com.dev_computing.covidintokpisin.ListItemRepository;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SlideshowViewModel extends ViewModel {
    private static final String TAG = "SlideshowViewModel";

    //variables
//    private ArrayList<String> mTitles = new ArrayList<>()
//    private ArrayList<String> mContents = new ArrayList<>();

    private MutableLiveData<List<ListItem>> mListItems;
    //instantiate Repository object
    private ListItemRepository mRepo;

    public void init() {
        Log.d(TAG, "init: started.");

        if (mListItems !=null){
            return;          //If the data has already been retrieved..

        }
        mRepo = ListItemRepository.getInstance();
        mListItems = mRepo.getListItems();

    }


//    private MutableLiveData<String> mTitles = new MutableLiveData<String>();

//    public LiveData<List<ListItem>> getListItems(){
//        Log.d(TAG, "getListItems: started");
//        return mListItems;
//    }

    //MutableLiveData is a subclass of LiveData
    public LiveData<List<ListItem>> getListItems() {
        Log.d(TAG, "getListItems: constructor initiated.");
        return mListItems;
    }



}
