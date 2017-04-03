package com.globant.counter.android.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.globant.counter.android.R;
import com.globant.counter.android.utils.SplashObject;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author s.ruiz
 */

public class SplashListAdapter extends BaseAdapter {
    private List<SplashObject> splashItems;

    @Override
    public int getCount() {
        return splashItems.size();
    }

    @Override
    public SplashObject getItem(int position) {
        return splashItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return splashItems.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SplashCardViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_splash, null);

            holder = new SplashCardViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.splash_item_id);
            holder.image = (ImageView) convertView.findViewById(R.id.splash_item_image);

            convertView.setTag(holder);
        } else {
            holder = (SplashCardViewHolder) convertView.getTag();
        }

        SplashObject splashObject = getItem(position);
        if (splashObject != null) {
            holder.id.setText(String.valueOf(splashObject.getId()));
            Picasso.with(parent.getContext()).load(splashObject.getUrl()).into(holder.image);
        }
        return convertView;
    }

    public void setSplashItems(List<SplashObject> images) {
        splashItems = images;
    }

    class SplashCardViewHolder {
        private TextView id;
        private ImageView image;
    }
}
