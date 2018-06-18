package com.wadexhong.coffeeordersystem.Task;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.wadexhong.coffeeordersystem.model.BitMapFunction;
import com.wadexhong.coffeeordersystem.model.CallBacks;
import com.wadexhong.coffeeordersystem.model.LRUSinglton;

/**
 * Created by wade8 on 2018/6/18.
 */

public class SetBitMapTask extends AsyncTask {

    private ImageView mImageView;
    private String mImageUrl;
    private CallBacks mCallBacks;

    public SetBitMapTask(ImageView imageView, String imageUrl, CallBacks callBacks){
        mImageView = imageView;
        mImageUrl = imageUrl;
        mCallBacks = callBacks;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        Bitmap bitmap = BitMapFunction.getSmallBitmap(mImageUrl);
        if (bitmap != null){
            LRUSinglton.getLruSinglton().put(mImageUrl, bitmap);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        mImageView.setImageBitmap(LRUSinglton.getLruSinglton().get(mImageUrl));
        mCallBacks.onCompleted();
    }
}
