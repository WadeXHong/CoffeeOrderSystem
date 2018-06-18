package com.wadexhong.coffeeordersystem.mainpage;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wadexhong.coffeeordersystem.Objects.Item;
import com.wadexhong.coffeeordersystem.R;
import com.wadexhong.coffeeordersystem.Task.SetBitMapTask;
import com.wadexhong.coffeeordersystem.model.BitMapFunction;
import com.wadexhong.coffeeordersystem.model.CallBacks;
import com.wadexhong.coffeeordersystem.model.LRUSinglton;

import java.util.ArrayList;
import java.util.concurrent.Executors;

/**
 * Created by wade8 on 2018/6/18.
 */

public class ItemsAdapter extends RecyclerView.Adapter {

    private ArrayList<Item> mItemArrayList;

    public ItemsAdapter(ArrayList<Item> itemArrayList){
        mItemArrayList = itemArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_coffeeitem, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemsViewHolder)holder).bind(position);
    }

    @Override
    public int getItemCount() {
        return mItemArrayList.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageView;

        public ItemsViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.item_main_coffeeitem_imageview);
        }

        private void bind(final int position){

            if (LRUSinglton.getLruSinglton().get(mItemArrayList.get(position).getImage()) != null){
                mImageView.setImageBitmap(LRUSinglton.getLruSinglton().get(mItemArrayList.get(position).getImage()));
            }else {
                SetBitMapTask task = new SetBitMapTask(mImageView, mItemArrayList.get(position).getImage(), new CallBacks() {
                    @Override
                    public void onCompleted() {
                    notifyDataSetChanged();
                    }
                });
                task.executeOnExecutor(Executors.newCachedThreadPool());
            }
        }
    }
}
