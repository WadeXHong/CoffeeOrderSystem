package com.wadexhong.coffeeordersystem.orderlistpage;

/**
 * Created by wade8 on 2018/6/18.
 */

public class OrderListPresenter implements OrderListContract.Presenter{

    private final OrderListContract.View mView;

    public OrderListPresenter(OrderListContract.View view) {
        mView = view;
    }

    @Override
    public void start() {

    }
}
