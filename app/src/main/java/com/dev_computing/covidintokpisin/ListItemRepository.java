package com.dev_computing.covidintokpisin;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class ListItemRepository {

    public static ListItemRepository instance;
    private ArrayList<ListItem> dataSet = new ArrayList<>();

    //return method
    public static ListItemRepository getInstance(){
        if (instance ==null){
            instance = new ListItemRepository();
        }
        return instance;
    }

    //pretend to get data from the webservice or online source
    public MutableLiveData<List<ListItem>> getListItems(){
        setListItems();
        MutableLiveData<List<ListItem>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setListItems(){

        dataSet.add(
                new ListItem("Namba blong ol sik manmeri", "630"));
        dataSet.add(
                new ListItem("Namba blong ol husait idai long sik covid", "7"));
        dataSet.add(
                new ListItem("Namba blong ol husait ikisim sik niupla", "18"));
        dataSet.add(
                new ListItem("Namba blong husait ol igat sik tete", "10"));
        dataSet.add(
                new ListItem("Namba blong husait kamap orait long sik covid", "588"));

    }
}
