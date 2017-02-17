package com.globant.counter.android.mvp.presenter;

import com.globant.counter.android.R;
import com.globant.counter.android.mvp.model.CalculateModel;
import com.globant.counter.android.mvp.view.CalculateView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author s.ruiz
 */

public class CalculatePresenter {
    private CalculateView view;
    private CalculateModel model;

    public CalculatePresenter(CalculateView view) {
        this.view = view;
        model = new CalculateModel();
    }

    public void setView(CalculateView view){
        if (view != null) {
            this.view = view;
        }
    }

    public void onEqualPressed() {
        if (view != null) {
            String value = view.getValues();
            Pattern full = Pattern.compile("(\\p{Digit}+)([+*/-]{1})(\\p{Digit}+)[=]{1}");
            Pattern unary = Pattern.compile("([+*/-]{1})(\\p{Digit}+)[=]{1}");
            Matcher mFull = full.matcher(value);
            Matcher mUnary = unary.matcher(value);

            Double result = .0;
            if (mFull.find() && mFull.groupCount() == 3) {
                result = model.operate(Double.valueOf(mFull.group(1)), Double.valueOf(mFull.group(3)), mFull.group(2).charAt(0));
            } else if (mUnary.find() && mUnary.groupCount() == 2) {
                result = model.operate(Double.valueOf(view.getLastResult()), Double.valueOf(mUnary.group(2)), mUnary.group(1).charAt(0));
            }
            view.setResult(result);
        }
    }

    private boolean isOperator(String value) {
        return value.matches("[+*/=-]");
    }

    private boolean isNumber(String value) {
        String regex = "\\d";
        return value.matches(regex);
    }

    public boolean isValid(char value) {
        return isNumber(String.valueOf(value)) || isOperator(String.valueOf(value));
    }

    public void lastInputWasInvalid(CharSequence charSequence) {
        if (view != null) {
            view.showErrorMessage(view.getActivity().getString(R.string.error_char));
            view.setTextWithoutInvokeListener(charSequence.subSequence(0, charSequence.length() - 1));
        }
    }
}
