package com.wadexhong.coffeeordersystem.mainpage;

import com.wadexhong.coffeeordersystem.BasePresenter;
import com.wadexhong.coffeeordersystem.BaseView;
import com.wadexhong.coffeeordersystem.Objects.Item;

/**
 * Created by wade8 on 2018/6/18.
 */

public interface MainPageContract {

    interface View extends BaseView<Presenter> {

        void setItemAdapter(ItemsAdapter itemAdapter);

        void setListAdapter(ListAdapter listAdapter);
    }

    interface Presenter extends BasePresenter {

        void setItemAdapter();

        void setListAdapter();

        void addOrder(Item item);
    }

}
