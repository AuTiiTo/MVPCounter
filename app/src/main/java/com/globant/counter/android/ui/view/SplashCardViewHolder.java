package com.globant.counter.android.ui.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.globant.counter.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author s.ruiz
 */

public class SplashCardViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.splash_item_id)
    TextView mItemId;

    @BindView(R.id.splash_item_image)
    ImageView mItemImage;

    public SplashCardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
