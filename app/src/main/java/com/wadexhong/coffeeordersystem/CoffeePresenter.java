package com.wadexhong.coffeeordersystem;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.wadexhong.coffeeordersystem.mainpage.MainPageFragment;
import com.wadexhong.coffeeordersystem.mainpage.MainPagePresenter;
import com.wadexhong.coffeeordersystem.orderdetailpage.OrderDetailFragment;
import com.wadexhong.coffeeordersystem.orderdetailpage.OrderDetailPresenter;
import com.wadexhong.coffeeordersystem.orderlistpage.OrderListFragment;
import com.wadexhong.coffeeordersystem.orderlistpage.OrderListPresenter;

/**
 * Created by wade8 on 2018/6/18.
 */

public class CoffeePresenter implements CoffeeContract.Presenter {

    private static final String PAGE_MAIN = "PAGE_MAIN";
    private static final String PAGE_ORDER_DETAIL = "PAGE_ORDER_DETAIL";
    private static final String PAGE_ORDER_LIST = "PAGE_ORDER_LIST";

    private final CoffeeContract.View mView;

    private FragmentManager mFragmentManager;
    private MainPageFragment mMainPageFragment;
    private OrderDetailFragment mOrderDetailFragment;
    private OrderListFragment mOrderListFragment;
    private MainPagePresenter mMainPagePresenter;
    private OrderDetailPresenter mOrderDetailPresenter;
    private OrderListPresenter mOrderListPresenter;

    public CoffeePresenter(CoffeeContract.View view, FragmentManager fragmentManager) {
        mView = view;
        mFragmentManager = fragmentManager;

        mView.setPresenter(this);
    }



    @Override
    public void start() {
        transToMainPage();
    }

    @Override
    public void transToMainPage() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        if (mMainPageFragment == null) {
            mMainPageFragment = MainPageFragment.newInstance();
            fragmentTransaction.add(R.id.activity_coffee_framelayout, mMainPageFragment, PAGE_MAIN);
        }else {
            fragmentTransaction.show(mMainPageFragment);
        }
        if (mMainPagePresenter == null) mMainPagePresenter = new MainPagePresenter(mMainPageFragment, this);

        if (mOrderListFragment != null){
            fragmentTransaction.hide(mOrderDetailFragment);
        }


        fragmentTransaction.commit();
    }

    @Override
    public void transToOrderDetail() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        if (mOrderListFragment == null) {
            mOrderListFragment = OrderListFragment.newInstance();
            fragmentTransaction.add(R.id.activity_coffee_framelayout, mOrderListFragment, PAGE_ORDER_LIST);
        }else {
            fragmentTransaction.show(mOrderListFragment);
        }
        if (mOrderListPresenter == null) mOrderListPresenter = new OrderListPresenter(mOrderListFragment);

        if (mMainPageFragment != null){
            fragmentTransaction.hide(mMainPageFragment);
        }
        if (mOrderListFragment != null){
            fragmentTransaction.hide(mOrderListFragment);
        }


        fragmentTransaction.commit();
    }

    @Override
    public void transToOrderList() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        if (mOrderDetailFragment == null) {
            mOrderDetailFragment = OrderDetailFragment.newInstance();
            fragmentTransaction.add(R.id.activity_coffee_framelayout, mOrderDetailFragment, PAGE_ORDER_LIST);
        }
        if (mOrderDetailPresenter == null) mOrderDetailPresenter = new OrderDetailPresenter(mOrderDetailFragment);

        if (mMainPageFragment != null){
            fragmentTransaction.hide(mMainPageFragment);
        }

        fragmentTransaction.addToBackStack(PAGE_ORDER_LIST);
        fragmentTransaction.commit();
    }
}
