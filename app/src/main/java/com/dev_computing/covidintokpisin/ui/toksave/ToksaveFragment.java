package com.dev_computing.covidintokpisin.ui.toksave;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev_computing.covidintokpisin.ListAdapter;
import com.dev_computing.covidintokpisin.ListItem;
import com.dev_computing.covidintokpisin.R;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

public class ToksaveFragment extends Fragment {
    private static final String TAG = "ToksaveFragment";

    private ToksaveViewModel mViewModel;
    private RecyclerView recyclerView;
    private TextView textView;
    private ListAdapter adapter;
    private ArrayList<ListItem> listItems = new ArrayList<>();


    public static ToksaveFragment newInstance() {

        return new ToksaveFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started.");

        View root = inflater.inflate(R.layout.toksave_fragment, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        textView = root.findViewById(R.id.text);

        mViewModel = new ViewModelProvider(this).get(ToksaveViewModel.class);

/*
        ToksaveViewModel.Webscrape webscrape = new ToksaveViewModel.Webscrape();
        new Thread(webscrape).start();
*/

        mViewModel.init();

        mViewModel.getListItems().observe(getViewLifecycleOwner(), new Observer<List<ListItem>>() {
            @Override
            public void onChanged(List<ListItem> listItems) {
                Log.d(TAG, "onChanged: ViewModel observed.");

                adapter.notifyDataSetChanged();

            }
        });


        initRecyclerView();



        return root;
//      return inflater.inflate(R.layout.toksave_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: started.");
        mViewModel = new ViewModelProvider(this).get(ToksaveViewModel.class);
        // TODO: Use the ViewModel

    }


    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: started.");

//        adapter = new ListAdapter(ToksaveFragment.this, listItems);
        adapter = new ListAdapter(this, (ArrayList<ListItem>) mViewModel.getListItems().getValue());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


    }


}