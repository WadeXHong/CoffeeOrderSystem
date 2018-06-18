package com.wadexhong.coffeeordersystem.mainpage;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wadexhong.coffeeordersystem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainPageFragment extends Fragment implements MainPageContract.View{

    private MainPageContract.Presenter mPresenter;

    public MainPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_page, container, false);
    }

    @Override
    public void setPresenter(MainPageContract.Presenter presenter) {
        mPresenter = presenter;
    }
}