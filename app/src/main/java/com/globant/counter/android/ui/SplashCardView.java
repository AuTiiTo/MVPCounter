package com.globant.counter.android.ui;

import android.widget.ImageView;
import android.widget.TextView;

import com.globant.counter.android.R;

import butterknife.BindView;

/**
 * @author s.ruiz
 */

public class SplashCardView{

    @BindView(R.id.splash_item_id)
    TextView mItemId;

    @BindView(R.id.splash_item_image)
    ImageView mItemImage;

    public TextView getmItemId() {
        return mItemId;
    }

    public ImageView getmItemImage() {
        return mItemImage;
    }
}
