package com.wadexhong.coffeeordersystem;

/**
 * Created by wade8 on 2018/6/18.
 */

public interface CoffeeContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter{

        void transToMainPage();

        void transToOrderDetail();

        void transToOrderList();

    }

}
