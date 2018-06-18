package com.wadexhong.coffeeordersystem.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wadexhong.coffeeordersystem.Objects.Item;

import java.util.ArrayList;

/**
 * Created by wade8 on 2018/6/18.
 */

public class FireBaseHelper {

    private static FireBaseHelper mInstance;

    public static FireBaseHelper getInstance(){
        if (mInstance == null) mInstance = new FireBaseHelper();
        return mInstance;
    }

    private FireBaseHelper(){

    }

    public ArrayList<Item> getItems(final CallBacks callBack){

        final ArrayList<Item> itemArrayList = new ArrayList<>();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("items");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot:dataSnapshot.getChildren()){

                    String imageUrl = (String) snapshot.child("image").getValue();
                    String name = (String) snapshot.child("name").getValue();
                    Long price = (Long) snapshot.child("price").getValue();
                    Log.d("test",imageUrl);
                    Log.d("test",name);
                    Log.d("test",price + "");
                    itemArrayList.add(new Item(imageUrl, name, price));
                }
                callBack.onCompleted();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return itemArrayList;
    }


}
