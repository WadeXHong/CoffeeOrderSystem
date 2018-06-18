package com.wadexhong.coffeeordersystem.orderdetailpage;

/**
 * Created by wade8 on 2018/6/18.
 */

public class OrderDetailPresenter implements OrderDetailContract.Presenter{

    private final OrderDetailContract.View mView;

    public OrderDetailPresenter(OrderDetailContract.View view) {
        mView = view;
    }

    @Override
    public void start() {

    }
}
