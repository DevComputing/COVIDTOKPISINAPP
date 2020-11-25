package com.dev_computing.covidintokpisin;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev_computing.covidintokpisin.ui.toksave.ToksaveFragment;


import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private static final String TAG = "ListAdapter";

    private ArrayList<ListItem> listItems;
    private ToksaveFragment context;

    public ListAdapter(ToksaveFragment context, ArrayList<ListItem> listItems) {
        Log.d(TAG, "ListAdapter: constructor initiated.");
        this.listItems = listItems;
        this.context = context;
    }


    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: started.");
//        return null;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
//        return new ViewHolder(view);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
//        ListItem listItem = listItems.get(position);
//        holder.textTitle.setText(listItem.getTitle());
//        holder.textView.setText(listItem.getText());

        holder.textTitle.setText(listItems.get(position).getTitle());
        holder.textView.setText(listItems.get(position).getText());
    }

    @Override
    public int getItemCount() {
//        return 0;
        return listItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private static final String TAG = "ViewHolder";

        TextView textTitle;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: started");
            textTitle = itemView.findViewById(R.id.title);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
