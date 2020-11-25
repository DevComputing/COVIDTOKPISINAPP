package com.dev_computing.covidintokpisin.ui.toksave;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dev_computing.covidintokpisin.ListItem;
import com.dev_computing.covidintokpisin.ListItemRepository;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.List;

public class ToksaveViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private static final String TAG = "ToksaveViewModel";

    private MutableLiveData<List<ListItem>> mListItems;
    private ListItemRepository mRepo; //instantiate Repository object

    public void init() {

        if (mListItems !=null){
            return;          //If the data has already been retrieved..

        }
        mRepo = ListItemRepository.getInstance();
        mListItems = mRepo.getListItems();

    }

    //MutableLiveData is a subclass of LiveData
    public LiveData<List<ListItem>> getListItems() {
        Log.d(TAG, "getListItems: constructor initiated.");
        return mListItems;
    }


/*
    public ToksaveViewModel() {
        Log.d(TAG, "ToksaveViewModel: started.");
        mListItems = new MutableLiveData<>();
        mListItems.setValue((List<ListItem>) new ListItem());
    }
*/


    /*
    public static class Webscrape implements Runnable{
        private static final String TAG = "Webscrape started.";
        private HttpCookie mListItems;

        @Override
        public void run() {

            try {
                String url = "https://covid19.info.gov.pg/";
                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla")
                        .timeout(300000)
                        .get();

                Elements data = doc.select("p.MsoNormal");

                int size = data.size();
                for( int i = 0; i<size; i++) {
                    String title = data.select("td[0]")

                            .select("span")
                            .eq(i)
                            .text();
                    String text = data.select("td[1]")
                            .select("span")
                            .eq(i)
                            .text();

//                    mListItems.add(new ListItem(title, text));
//                    mListItems.setValue(String.valueOf(new ListItem(title, text)));
                    mListItems.setValue(text);
                    Log.d(TAG, "run: title:" + title + ". text:" +text);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
*/

}