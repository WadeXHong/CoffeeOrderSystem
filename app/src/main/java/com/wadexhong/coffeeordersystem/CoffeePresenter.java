package com.wadexhong.coffeeordersystem;

/**
 * Created by wade8 on 2018/6/18.
 */

public class CoffeePresenter implements CoffeeContract.Presenter {

    private final CoffeeContract.View mView;

    public CoffeePresenter(CoffeeContract.View view) {
        mView = view;
    }

    @Override
    public void start() {

    }
}
