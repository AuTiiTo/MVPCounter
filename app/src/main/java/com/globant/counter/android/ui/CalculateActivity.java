package com.globant.counter.android.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.globant.counter.android.R;
import com.globant.counter.android.mvp.presenter.CalculatePresenter;
import com.globant.counter.android.mvp.view.CalculateView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author s.ruiz
 */

public class CalculateActivity extends Activity implements CalculateView {
    private CalculatePresenter presenter;

    @BindView(R.id.values)
    EditText valuesToOperate;
    @BindView(R.id.result)
    TextView result;
    private TextWatcher textWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        ButterKnife.bind(this);
        presenter = new CalculatePresenter(this);
        addEditListeners();
    }

    @Override
    public void setResult(Double result) {
        this.result.setText(String.valueOf(result));
    }

    @Override
    public String getLastResult() {
        try {
            return String.valueOf(result.getText());
        } catch (Exception exp) {
            return "0";
        }
    }

    @Override
    public void setTextWithoutInvokeListener(CharSequence charSequence) {
        valuesToOperate.removeTextChangedListener(textWatcher);
        valuesToOperate.setText(charSequence);
        valuesToOperate.setSelection(charSequence.length());
        valuesToOperate.addTextChangedListener(textWatcher);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getBaseContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    private void addEditListeners() {
        textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int length, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int last, int i1, int i2) {
                try {
                    if (!presenter.isValid(charSequence.charAt(charSequence.length() - 1))) {
                        presenter.lastInputWasInvalid(charSequence);
                    }
                } catch (Exception exp) {
//                    showErrorMessage(getString(R.string.error_empty));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().contains("=")) {
                    presenter.onEqualPressed();
                }
            }
        };

        valuesToOperate.addTextChangedListener(textWatcher);
        valuesToOperate.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                valuesToOperate.setText("");
                return true;
            }
        });
    }

    public String getValues() {
        return String.valueOf(valuesToOperate.getText());
    }


    public Activity getActivity() {
        return this;
    }
}
