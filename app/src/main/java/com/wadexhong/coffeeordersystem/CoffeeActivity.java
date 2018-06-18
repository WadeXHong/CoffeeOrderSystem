package com.wadexhong.coffeeordersystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.wadexhong.coffeeordersystem.model.FireBaseHelper;

public class CoffeeActivity extends AppCompatActivity implements CoffeeContract.View, View.OnClickListener{

    private CoffeeContract.Presenter mPresenter;

    private ImageView mImageViewMainPage;
    private ImageView mImageViewListPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        mImageViewMainPage = findViewById(R.id.activity_coffee_bottom_tab_main);
        mImageViewListPage = findViewById(R.id.activity_coffee_bottom_tab_list);

        mImageViewMainPage.setOnClickListener(this);
        mImageViewListPage.setOnClickListener(this);

        mPresenter = new CoffeePresenter(this, getFragmentManager());
        // just for test
//        FireBaseHelper.getInstance().getItems();

        mPresenter.start();
    }

    @Override
    public void setPresenter(CoffeeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.activity_coffee_bottom_tab_main:
                mPresenter.transToMainPage();

                break;

            case R.id.activity_coffee_bottom_tab_list:
                mPresenter.transToOrderList();
                break;
        }
    }
}
