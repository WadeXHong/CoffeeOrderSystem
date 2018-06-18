package com.wadexhong.coffeeordersystem.mainpage;

import com.wadexhong.coffeeordersystem.Objects.Item;
import com.wadexhong.coffeeordersystem.model.CallBacks;
import com.wadexhong.coffeeordersystem.model.FireBaseHelper;

/**
 * Created by wade8 on 2018/6/18.
 */

public class MainPagePresenter implements MainPageContract.Presenter {

    private final MainPageContract.View mView;
    private ItemsAdapter mItemAdapter;
    private ListAdapter mListAdapter;

    public MainPagePresenter(MainPageContract.View view) {
        mView = view;

        mView.setPresenter(this);
    }


    @Override
    public void start() {

    }

    @Override
    public void setItemAdapter() {
        mItemAdapter = new ItemsAdapter(this ,FireBaseHelper.getInstance().getItems(new CallBacks() {
            @Override
            public void onCompleted() {
                mItemAdapter.notifyDataSetChanged();
            }
        }));

        mView.setItemAdapter(mItemAdapter);
    }

    @Override
    public void setListAdapter() {
        mListAdapter = new ListAdapter();
        mView.setListAdapter(mListAdapter);
    }

    @Override
    public void addOrder(Item item) {
        mListAdapter.addItem(item);
    }
}
