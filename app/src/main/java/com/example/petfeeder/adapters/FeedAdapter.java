package com.example.petfeeder.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.petfeeder.R;
import com.example.petfeeder.models.FeedData;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    public FeedData[] feedList;

    public FeedAdapter(FeedData[] feedList){
        this.feedList = feedList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.feed_automatic_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final FeedData feedListData = feedList[position];
        holder.feedTxt.setText(feedList[position].getName());
        holder.dateTxt.setText(feedList[position].getDate());
        holder.amountTxt.setText(feedList[position].getAmount());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+ feedListData.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return feedList.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView deleteIcon;
        public TextView feedTxt;
        public TextView dateTxt;
        public TextView amountTxt;
        public RelativeLayout container;

        public ViewHolder(View itemView) {
            super(itemView);
            deleteIcon = (ImageView) itemView.findViewById(R.id.feed_delete_item_btn);
            feedTxt = (TextView) itemView.findViewById(R.id.feed_name_item_list);
            dateTxt = (TextView) itemView.findViewById(R.id.feed_date_item_list);
            amountTxt = (TextView) itemView.findViewById(R.id.feed_amount_item_list);
            container = (RelativeLayout)itemView.findViewById(R.id.feed_list_item_container);
        }
    }
}
