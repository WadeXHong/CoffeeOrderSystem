package com.wadexhong.coffeeordersystem.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import com.wadexhong.coffeeordersystem.Coffee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wade8 on 2018/6/18.
 */

public class BitMapFunction {

    public static Bitmap getSmallBitmap(String imageUrl) {
        Bitmap bitmap = null;

        try {
            InputStream input = new URL(imageUrl).openStream();
            // 設置參數
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true; // 只獲取圖片的大小信息，而不是將整張圖片載入在內存中，避免內存溢出
            BitmapFactory.decodeStream(input,null, options);
            int height = options.outHeight;
            int width= options.outWidth;

            int inSampleSize = 1;

            if (height > 400 || width > 400) {

                final int halfHeight = height / 2;
                final int halfWidth = width / 2;

                // Calculate the largest inSampleSize value that is a power of 2 and keeps both
                // height and width larger than the requested height and width.
                while ((halfHeight / inSampleSize) > 400
                          && (halfWidth / inSampleSize) > 400) {
                    inSampleSize += 1;
                }
            }
            InputStream input2 = new URL(imageUrl).openStream();
            options.inJustDecodeBounds = false; // 計算好壓縮比例後，這次可以去加載原圖了
            options.inSampleSize = inSampleSize; // 設置為剛才計算的壓縮比例
            bitmap = BitmapFactory.decodeStream(input2, null, options); // 解碼文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
