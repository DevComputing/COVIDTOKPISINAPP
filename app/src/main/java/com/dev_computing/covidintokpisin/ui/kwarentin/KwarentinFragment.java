package com.dev_computing.covidintokpisin.ui.kwarentin;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev_computing.covidintokpisin.R;

public class KwarentinFragment extends Fragment {

    private KwarentinViewModel mViewModel;

    public static KwarentinFragment newInstance() {

        return new KwarentinFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kwarentin, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(KwarentinViewModel.class);
        // TODO: Use the ViewModel
    }

}