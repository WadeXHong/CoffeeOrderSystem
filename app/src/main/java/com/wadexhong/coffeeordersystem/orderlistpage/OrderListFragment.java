package com.wadexhong.coffeeordersystem.orderlistpage;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wadexhong.coffeeordersystem.R;
import com.wadexhong.coffeeordersystem.orderdetailpage.OrderDetailContract;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderListFragment extends Fragment implements OrderListContract.View{

    private OrderListContract.Presenter mPresenter;

    public static OrderListFragment newInstance() {
        return new OrderListFragment();
    }


    public OrderListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_list, container, false);
    }

    @Override
    public void setPresenter(OrderListContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
