package com.wadexhong.coffeeordersystem.mainpage;

import com.wadexhong.coffeeordersystem.CoffeeContract;
import com.wadexhong.coffeeordersystem.Objects.Item;
import com.wadexhong.coffeeordersystem.model.CallBacks;
import com.wadexhong.coffeeordersystem.model.FireBaseHelper;

import java.util.ArrayList;

/**
 * Created by wade8 on 2018/6/18.
 */

public class MainPagePresenter implements MainPageContract.Presenter {

    private final MainPageContract.View mView;
    private CoffeeContract.Presenter mCoffeePresenter;
    private ItemsAdapter mItemAdapter;
    private ListAdapter mListAdapter;

    public MainPagePresenter(MainPageContract.View view, CoffeeContract.Presenter coffeePresenter) {
        mView = view;
        mCoffeePresenter = coffeePresenter;

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

    @Override
    public void pressConfirm() {
        ArrayList itemArrayList = mListAdapter.getItemArrayList();
        if (itemArrayList != null && itemArrayList.size() != 0){

            // 幹 想要包成FireBase的格式 好痛苦
            mCoffeePresenter.transToOrderDetail(itemArrayList);
        }
    }
}
