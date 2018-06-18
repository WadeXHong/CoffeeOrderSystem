package com.wadexhong.coffeeordersystem.Objects;

/**
 * Created by wade8 on 2018/6/18.
 */

public class Item {

    private String mImage;
    private String mName;
    private Long mPrice;

    private boolean mIsIce;

    private boolean mIsSugar;

    public Item(String image, String name, Long price) {
        mImage = image;
        mName = name;
        mPrice = price;
        mIsIce = true;
        mIsSugar = true;
    }

    public boolean isIce() {
        return mIsIce;
    }

    public void setIce(boolean ice) {
        mIsIce = ice;
    }

    public boolean isSugar() {
        return mIsSugar;
    }

    public void setSugar(boolean sugar) {
        mIsSugar = sugar;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getPrice() {
        return mPrice;
    }

    public void setPrice(Long price) {
        mPrice = price;
    }
}
