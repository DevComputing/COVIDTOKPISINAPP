package com.dev_computing.covidintokpisin.ui.slideshow;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.dev_computing.covidintokpisin.ListItem;
import com.dev_computing.covidintokpisin.ListItemAdapter;
import com.dev_computing.covidintokpisin.R;
import com.dev_computing.covidintokpisin.ui.slideshow.SlideshowViewModel;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class SlideshowFragment extends Fragment{
    private static final String TAG = "SlideshowFragment";

    //variables
    private TextView text;
    private TextView title;
    private SlideshowViewModel slideshowViewModel;
    private RecyclerView recyclerView;

//    private ToksaveViewModel mViewModel;
    private TextView textView;
    private ListItemAdapter adapter;
    private ArrayList<ListItem> listItems = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started.");

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        text = root.findViewById(R.id.text);
        title = root.findViewById(R.id.title);
        recyclerView = root.findViewById(R.id.recyclerView);


        slideshowViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);
        slideshowViewModel.init();
        slideshowViewModel.getListItems().observe(getViewLifecycleOwner(), new Observer<List<ListItem>>() {
            @Override
            public void onChanged(List<ListItem> listItems) {
                adapter.notifyDataSetChanged();

            }
        });


        initRecyclerView();


//      slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//
//            }
//        });

        return root;

        }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: started.");

//        adapter = new ListAdapter(this, slideshowViewModel.getListItems().getValue());
        adapter = new ListItemAdapter(this, slideshowViewModel.getListItems().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

}






