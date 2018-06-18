package com.wadexhong.coffeeordersystem.model;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by wade8 on 2018/6/18.
 */

public class LRUSinglton extends LruCache<String,Bitmap> {
    private static LRUSinglton lruSinglton;
    static final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

    // Use 1/8th of the available memory for this memory cache.
    static final int cacheSize = maxMemory / 2;

    private LRUSinglton(int cacheSize) {
        super(cacheSize);

    }

    public static LRUSinglton getLruSinglton() {
        if (lruSinglton == null) {
            lruSinglton = new LRUSinglton(cacheSize);
        }
        return lruSinglton;
    }

    @Override
    protected int sizeOf(String key, Bitmap value) {
        int kbOfBitmap = value.getByteCount() / 1024;
        return kbOfBitmap;
    }


    public void addBitmapToLruCache(String url, Bitmap bitmap) {
        if (lruSinglton.get(url) == null) {
            lruSinglton.put(url, bitmap);
        }
    }
}
