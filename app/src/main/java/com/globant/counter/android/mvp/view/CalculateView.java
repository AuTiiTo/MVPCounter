package com.globant.counter.android.mvp.view;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.globant.counter.android.R;
import com.squareup.otto.Bus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnLongClick;

/**
 * @author s.ruiz
 */

public class CalculateView extends ActivityView {

    private final Bus bus;
    private TextWatcher textWatcher;

    @BindView(R.id.values)
    EditText valuesToOperate;
    @BindView(R.id.result)
    TextView result;
    private CharSequence lastInput;

    public CalculateView(Activity activity, Bus bus) {
        super(activity);
        this.bus = bus;
        ButterKnife.bind(this, activity);
        addEditListeners();
    }

    public void setResult(Double result) {
        this.result.setText(String.valueOf(result));
    }

    public Double getLastResult() {
        try {
            return Double.valueOf(result.getText().toString());
        } catch (Exception exp) {
            return .0;
        }
    }

    public String getValues() {
        return String.valueOf(valuesToOperate.getText());
    }

    public CharSequence getLastInput() {
        return lastInput;
    }

    public void setTextWithoutInvokeListener(CharSequence charSequence) {
        valuesToOperate.removeTextChangedListener(textWatcher);
        valuesToOperate.setText(charSequence);
        valuesToOperate.setSelection(charSequence.length());
        valuesToOperate.addTextChangedListener(textWatcher);

    }

    public void showErrorMessage(String errorMessage) {
        Toast.makeText(CalculateView.super.getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

//    @OnTextChanged(value = R.id.values, callback = OnTextChanged.Callback.TEXT_CHANGED)
//    void valuesChanged(CharSequence charSequence, int last, int i1, int i2) {
//        lastInput = charSequence;
//        bus.post(new OnInputEvent());
//    }
//    @OnTextChanged(value = R.id.values, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
//    void afterValues(Editable editable) {
//        if (editable.toString().contains("/0=")) {
//            showErrorMessage(CalculateView.super.getContext().getString(R.string.error_divition));
//            showErrorMessage(CalculateView.super.getContext().getString(R.string.error_empty));
//        }else if (editable.toString().contains("=")) {
//            bus.post(new OnOperationEvent());
//        }
//    }
//
    @OnLongClick(R.id.values)
    boolean onValuesLongClick() {
        setTextWithoutInvokeListener("");
        return true;
    }
    private void addEditListeners() {
        textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int length, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int last, int i1, int i2) {
                lastInput = charSequence;
                bus.post(new OnInputEvent());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                bus.post(new OnOperationEvent());

                // if (editable.toString().contains("/0=")) {
//                                showErrorMessage(CalculateView.super.getContext().getString(R.string.error_divition));
//                    showErrorMessage(CalculateView.super.getContext().getString(R.string.error_empty));
//                } else if (editable.toString().contains("=")) {
//                    bus.post(new OnOperationEvent());
//                }
            }
        };

        valuesToOperate.addTextChangedListener(textWatcher);
    }

//    Events
    public static class OnOperationEvent {
    }
    public static class OnInputEvent {
    }
}
