package com.globant.counter.android.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.globant.counter.android.R;
import com.globant.counter.android.utils.SplashObject;
import com.squareup.picasso.Picasso;


/**
 * @author s.ruiz
 */

public class SplashFragmentDialog extends DialogFragment {

    private SplashObject mImage;

    public static SplashFragmentDialog newInstance(SplashObject image) {
        SplashFragmentDialog fragmentDialog = new SplashFragmentDialog();

        Bundle bundle = new Bundle();
        bundle.putSerializable("image", image);
        fragmentDialog.setArguments(bundle);
        return fragmentDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImage = (SplashObject) getArguments().getSerializable("image");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container);
        TextView id = (TextView) view.findViewById(R.id.fragment_item_id);
        ImageView image = (ImageView) view.findViewById(R.id.fragment_item_image);
        id.setText(String.valueOf(mImage.getId()));
        Picasso.with(view.getContext()).load(mImage.getUrl()).into(image);
        return view;
    }
}
