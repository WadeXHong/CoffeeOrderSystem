package com.wadexhong.coffeeordersystem.Objects;

import java.util.ArrayList;

/**
 * Created by wade8 on 2018/6/18.
 */

public class Order {

    private final String account = "wayne.chen@awscafe.tw";
    private int itemCount;
    private int price;
    private int status;
    private long time;
    private ArrayList<Item> mItemArrayList;


    public Order(ArrayList<Item> itemArrayList){
        mItemArrayList = itemArrayList;
        itemCount = itemArrayList.size();
        for (Item item:itemArrayList){
            switch (item.getName()){
                case "Espresso":
                    item = (Expresso)item;
            }
        }

    }
}
