package com.globant.counter.android.ui.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.globant.counter.android.R;
import com.globant.counter.android.utils.BusProvider;
import com.globant.counter.android.utils.SplashObject;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author s.ruiz
 */

public class SplashListAdapter extends RecyclerView.Adapter<SplashCardViewHolder> {
    private List<SplashObject> splashItems;
    private Context mContext;
    private final Bus eventBus = BusProvider.getInstance();

    @Override
    public SplashCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_splash, null);
        SplashCardViewHolder viewHolder = new SplashCardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SplashCardViewHolder holder, int position) {
        final SplashObject item = splashItems.get(position);
        holder.mItemId.setText(String.valueOf(item.getId()));
        Picasso.with(mContext).load(item.getUrl()).into(holder.mItemImage);
        holder.mItemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventBus.post(new ItemClickEvent(item.getId()));
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return splashItems.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return splashItems.size();
    }

    public void setSplashItems(List<SplashObject> images) {
        splashItems = images;
    }

    public static class ItemClickEvent {
        final int id;
        public ItemClickEvent(int itemId) {
            id = itemId;
        }
        public int getItemId(){
            return id;
        }
    }
}
