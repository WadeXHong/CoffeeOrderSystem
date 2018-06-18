package com.wadexhong.coffeeordersystem.mainpage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wadexhong.coffeeordersystem.Objects.Item;
import com.wadexhong.coffeeordersystem.R;
import com.wadexhong.coffeeordersystem.Task.SetBitMapTask;
import com.wadexhong.coffeeordersystem.model.CallBacks;
import com.wadexhong.coffeeordersystem.model.LRUSinglton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.Executors;

/**
 * Created by wade8 on 2018/6/18.
 */

public class ListAdapter extends RecyclerView.Adapter {

    private ArrayList<Item> mItemArrayList = new ArrayList<>();

    public ListAdapter() {
    }

    public void addItem(Item item) {
        mItemArrayList.add(item);
        notifyItemChanged(mItemArrayList.size()-1);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_listitem, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bind(position);
    }

    @Override
    public int getItemCount() {
        return mItemArrayList.size();
    }

    public ArrayList<Item> getItemArrayList() {
        return mItemArrayList;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTitle;
        private RadioButton mIced;
        private RadioButton mHot;
        private RadioButton mSugar;
        private RadioButton mNoSugar;
        private RadioGroup mIcedGroup;
        private RadioGroup mSugarGroup;

        public ListViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.item_main_listitem_imageview);
            mTitle = itemView.findViewById(R.id.item_main_listitem_textview_name);
            mIced = itemView.findViewById(R.id.item_main_listitem_radiobutton_iced);
            mHot = itemView.findViewById(R.id.item_main_listitem_radiobutton_hot);
            mSugar = itemView.findViewById(R.id.item_main_listitem_radiobutton_yes);
            mNoSugar = itemView.findViewById(R.id.item_main_listitem_radiobutton_no);
            mIcedGroup = itemView.findViewById(R.id.item_main_listitem_radiogroup_type);
            mSugarGroup = itemView.findViewById(R.id.item_main_listitem_radiogroup_sugar);




        }

        public void bind(final int position) {

            if (LRUSinglton.getLruSinglton().get(mItemArrayList.get(position).getImage()) != null) {
                mImageView.setImageBitmap(LRUSinglton.getLruSinglton().get(mItemArrayList.get(position).getImage()));
            } else {
                SetBitMapTask task = new SetBitMapTask(mImageView, mItemArrayList.get(position).getImage(), new CallBacks() {
                    @Override
                    public void onCompleted() {
                        notifyDataSetChanged();
                    }
                });
                task.executeOnExecutor(Executors.newCachedThreadPool());
            }

            mTitle.setText(mItemArrayList.get(position).getName());

            mIcedGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (checkedId == R.id.item_main_listitem_radiobutton_iced){
                        mItemArrayList.get(position).setIce(true);
                    }else {
                        mItemArrayList.get(position).setIce(false);
                    }
                }
            });
            mSugarGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (checkedId == R.id.item_main_listitem_radiobutton_yes){
                        mItemArrayList.get(position).setSugar(true);
                    }else {
                        mItemArrayList.get(position).setSugar(false);
                    }
                }
            });

//            mIced.setOnCheckedChangeListener();
//            mHot.setOnCheckedChangeListener(mOnCheckedChangeListener);
//            mSugar.setOnCheckedChangeListener(mOnCheckedChangeListener);
//            mNoSugar.setOnCheckedChangeListener(mOnCheckedChangeListener);

            mIced.setChecked(mItemArrayList.get(position).isIce());
            mHot.setChecked(!mItemArrayList.get(position).isIce());
            mSugar.setChecked(mItemArrayList.get(position).isSugar());
            mNoSugar.setChecked(!mItemArrayList.get(position).isSugar());
        }

//        private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                switch (buttonView.getId()) {
//                    case R.id.item_main_listitem_radiobutton_iced:
//                        mItemArrayList.get(getLayoutPosition()).setIce(true);
//                        break;
//                    case R.id.item_main_listitem_radiobutton_hot:
//                        mItemArrayList.get(getLayoutPosition()).setIce(false);
//                        break;
//                    case R.id.item_main_listitem_radiobutton_yes:
//                        mItemArrayList.get(getLayoutPosition()).setSugar(true);
//                        break;
//                    case R.id.item_main_listitem_radiobutton_no:
//                        mItemArrayList.get(getLayoutPosition()).setSugar(false);
//                        break;
//                }
//            }
//        };
    }
}
