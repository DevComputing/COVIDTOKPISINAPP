package com.dev_computing.covidintokpisin;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListItemRepository {
    private static final String TAG = "ListItemRepository";

    public static ListItemRepository instance;
    private final ArrayList<ListItem> dataSet = new ArrayList<>();
    private String title;
    private String text;



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

//        setListItems();

    Webscrape webscrape = new Webscrape();
    new Thread(webscrape).start();


        MutableLiveData<List<ListItem>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    /**********Manual source of Data**********/

 /*   private void setListItems(){

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

                        Log.d(TAG, "run: webscraping:" + dataSet);

    }
*/

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

                Elements data = doc.select("table.MsoTable15Grid5DarkAccent3");

                    Log.d(TAG, "run: iteration started.");


                for (Element row : doc.select(
                        "table.MsoTable15Grid5DarkAccent3 tr")){
                    if (row.select("td:nth-of-type(1)").text().equals("")) {
                        continue;
                    }
                    else {
                        final String title = row.select("td:nth-of-type(1)").text();
                        final String text = row.select("td:nth-of-type(2)").text();

                        dataSet.add(new ListItem(title, text));

                        Log.d("webscraping", "run: initiated." + "title: " +title);

                    }


                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
