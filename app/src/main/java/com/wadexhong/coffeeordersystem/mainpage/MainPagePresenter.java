package com.wadexhong.coffeeordersystem.mainpage;

/**
 * Created by wade8 on 2018/6/18.
 */

public class MainPagePresenter implements MainPageContract.Presenter {

    private final MainPageContract.View mView;

    public MainPagePresenter(MainPageContract.View view) {
        mView = view;
    }


    @Override
    public void start() {

    }
}
