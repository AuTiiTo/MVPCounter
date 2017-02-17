package com.globant.counter.android.mvp.view;

import android.app.Activity;

/**
 * @author s.ruiz
 */

public interface CalculateView {
    void setResult(Double result);
    void setTextWithoutInvokeListener(CharSequence charSequence);
    void showErrorMessage(String errorMessage);
    Activity getActivity();
    String getValues();
    String getLastResult();
}
