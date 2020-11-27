package com.dev_computing.covidintokpisin;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev_computing.covidintokpisin.ui.slideshow.SlideshowFragment;

import java.util.ArrayList;
import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ViewHolder> {
    private static final String TAG = "ListItemAdapter";

    private ArrayList<ListItem> listItems;
    private SlideshowFragment context;

    public ListItemAdapter(SlideshowFragment context, List<ListItem> listItems) {
        this.listItems = (ArrayList<ListItem>) listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ListItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: started.");
//        return null;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
//        ListAdapter.ViewHolder vh = new ListAdapter.ViewHolder(view);
//        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        ListItem listItem = listItems.get(position);

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
            Log.d(TAG, "ViewHolder: started.");

            textTitle = itemView.findViewById(R.id.title);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
