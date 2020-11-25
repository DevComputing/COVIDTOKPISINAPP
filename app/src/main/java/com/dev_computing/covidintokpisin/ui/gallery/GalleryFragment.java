package com.dev_computing.covidintokpisin.ui.gallery;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dev_computing.covidintokpisin.R;
import com.dev_computing.covidintokpisin.ui.gallery.GalleryViewModel;

public class GalleryFragment extends Fragment implements View.OnClickListener {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);

        final ImageView imageView = root.findViewById(R.id.image_call);
        imageView.setOnClickListener(this);


        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) { textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onClick(View v) {
//        String number = "1-800200";
        switch (v.getId()) {
            case R.id.image_call:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                 intent.setData(Uri.parse("tel: 1800200"));
                            startActivity(intent);
                  break;

        }
    }
}
