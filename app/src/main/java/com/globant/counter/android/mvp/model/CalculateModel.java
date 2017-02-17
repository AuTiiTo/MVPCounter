package com.globant.counter.android.mvp.model;

/**
 * @author s.ruiz
 */

public class CalculateModel {

    private Double result;

    public CalculateModel() {
        result = .0;
    }

    public void add(float input) {
        result = result + input;
    }

    public void subtract(float input) {
        result = result - input;
    }

    public Double operate(Double first, Double second, char operator) {
        Double result = .0;
        switch (operator) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '/':
                if (second != 0) {
                    result = first / second;
                }
                break;
            default:
                result = first * second;
                break;
        }
        return result;
    }
}
