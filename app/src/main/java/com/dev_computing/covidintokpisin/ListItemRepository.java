package com.dev_computing.covidintokpisin;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListItemRepository {
    private static final String TAG = "ListItemRepository";

    public static ListItemRepository instance;
    private ArrayList<ListItem> dataSet = new ArrayList<>();

    //return method
    public static ListItemRepository getInstance(){
        if (instance ==null){
            instance = new ListItemRepository();
        }
        return instance;
    }

    //Get data from the webservice or online source
    public MutableLiveData<List<ListItem>> getListItems(){
        Log.d(TAG, "getListItems: started.");

        setListItems();

/*
        Webscrape webscrape = new Webscrape();
        new Thread(webscrape).start();
*/

        MutableLiveData<List<ListItem>> data = new MutableLiveData<>();
        data.setValue(dataSet);
//        data.setValue(mListItems);
        return data;
    }

    private void setListItems(){

        dataSet.add(
                new ListItem("Namba blong sik insait long kauntri", "630"));
        dataSet.add(
                new ListItem("Namba blong ol husait dai long sik covid", "7"));
        dataSet.add(
                new ListItem("Namba blong ol husait kisim sik niupla", "18"));
        dataSet.add(
                new ListItem("Namba blong husait ol gat sik tete", "10"));
        dataSet.add(
                new ListItem("Namba blong husait kamap orait", "588"));

    }

/*
    public class Webscrape implements Runnable{
        private static final String TAG = "Webscrape started.";

        @Override
        public void run() {
            Log.d(TAG, "run: initiated.");

            try {
                String url = "https://covid19.info.gov.pg/";
                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla")
                        .timeout(300000)
                        .get();

                Elements data = doc.select("p.MsoNormal");

                int size = data.size();
                for( int i = 0; i<size; i++) {
                    Log.d(TAG, "run: iteration started.");
                    String title = data.select("td[0]")
                            .select("span")
                            .eq(i)
                            .text();
                    String text = data.select("td[1]")
                            .select("span")
                            .eq(i)
                            .text();

//                    mListItems.add(new ListItem(title, text));
                    dataSet.add(new ListItem(title, text));


                    Log.d(TAG, "run: title:" + title + ". text:" +text);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
*/
}
