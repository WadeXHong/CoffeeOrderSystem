package com.wadexhong.coffeeordersystem.mainpage;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wadexhong.coffeeordersystem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainPageFragment extends Fragment implements MainPageContract.View{

    private MainPageContract.Presenter mPresenter;

    private RecyclerView mRecyclerViewItem;
    private RecyclerView mRecyclerViewList;

    public static MainPageFragment newInstance(){
        return new MainPageFragment();
    }

    public MainPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);

        mRecyclerViewItem = view.findViewById(R.id.fragment_mainpage_recyclerview_item);
        mRecyclerViewList = view.findViewById(R.id.fragment_mainpage_recyclerview_list);

        mRecyclerViewItem.setLayoutManager(new GridLayoutManager(getContext(), 2, OrientationHelper.HORIZONTAL, false));
        mPresenter.setItemAdapter();

        mRecyclerViewList.setLayoutManager(new LinearLayoutManager(getContext()));
        mPresenter.setListAdapter();


        return view;
    }

    @Override
    public void setPresenter(MainPageContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setItemAdapter(ItemsAdapter itemAdapter) {
        mRecyclerViewItem.setAdapter(itemAdapter);
    }

    @Override
    public void setListAdapter(ListAdapter listAdapter) {
        mRecyclerViewList.setAdapter(listAdapter);
    }
}
