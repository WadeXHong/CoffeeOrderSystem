package com.wadexhong.coffeeordersystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CoffeeActivity extends AppCompatActivity implements CoffeeContract.View{

    private CoffeeContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        mPresenter.start();
    }

    @Override
    public void setPresenter(CoffeeContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
