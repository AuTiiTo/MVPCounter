package com.globant.counter.android.mvp.presenter;

import com.globant.counter.android.mvp.model.CalculateModel;
import com.globant.counter.android.mvp.view.CalculateView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

/**
 * @author s.ruiz
 */
public class CalculatePresenterTest {

    private CalculateView view;
    private CalculatePresenter presenter;
    private CalculateModel model;

    @Before
    public void setup() {
        model = new CalculateModel();
        view = mock(CalculateView.class);
        presenter = new CalculatePresenter(view, model);
    }

    @Test
    public void operationValid() throws Exception {
        Mockito.when(view.getValues()).thenReturn("2+3=");
        presenter.onOperation(new CalculateView.OnOperationEvent());
    }

    /*NullPointerException expected because the view is mocked
    * and the method view.getContext() return Null*/
    @Test(expected = NullPointerException.class)
    public void operationInvalid() throws Exception {
        Mockito.when(view.getValues()).thenReturn("2/0=");
        presenter.onOperation(new CalculateView.OnOperationEvent());
    }
}