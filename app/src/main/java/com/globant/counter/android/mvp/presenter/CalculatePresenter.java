package com.globant.counter.android.mvp.presenter;

import android.support.annotation.NonNull;

import com.globant.counter.android.R;
import com.globant.counter.android.mvp.model.CalculateModel;
import com.globant.counter.android.mvp.view.CalculateView;
import com.globant.counter.android.mvp.view.CalculateView.OnEqualPressedEvent;
import com.squareup.otto.Subscribe;

/**
 * @author s.ruiz
 */

public class CalculatePresenter {
    @NonNull
    private CalculateView view;
    @NonNull
    private CalculateModel model;

    public CalculatePresenter(CalculateView view, CalculateModel model) {
        this.view = view;
        this.model = model;
    }

    @Subscribe
    public void onEqualPressed(OnEqualPressedEvent event) {
        String value = view.getValues();
        view.setResult(model.getResult(value, view.getLastResult()));
    }

    @Subscribe
    public void onInput(CalculateView.OnInputEvent event) {
        try {
            CharSequence input = view.getLastInput();
            if (!isValid(input.charAt(input.length() - 1))) {
                view.showErrorMessage(view.getActivity().getString(R.string.error_char));
                view.setTextWithoutInvokeListener(input.subSequence(0, input.length() - 1));
            }
        } catch (Exception exp) { }
    }

    public boolean isValid(char value) {
        return model.isNumber(String.valueOf(value)) || model.isOperator(String.valueOf(value));
    }
}
