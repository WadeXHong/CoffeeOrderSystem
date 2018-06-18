package com.wadexhong.coffeeordersystem.Objects;

/**
 * Created by wade8 on 2018/6/18.
 */

public class Item {

    private String mImage;
    private String mName;
    private Long mPrice;

    public Item(String image, String name, Long price) {
        mImage = image;
        mName = name;
        mPrice = price;
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
