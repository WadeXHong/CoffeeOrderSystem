package com.wadexhong.coffeeordersystem;

import android.app.Application;
import android.content.Context;

/**
 * Created by wade8 on 2018/6/18.
 */

public class Coffee extends Application{
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
    }

    public static Context getAppContext(){
        return mContext;
    }
}
