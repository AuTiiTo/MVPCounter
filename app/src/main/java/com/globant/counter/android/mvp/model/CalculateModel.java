package com.globant.counter.android.mvp.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author s.ruiz
 */

public class CalculateModel {

    private static final char CALCULATE_SUM = '+';
    private static final char CALCULATE_SUBSTRACT = '-';
    private static final char CALCULATE_MULTIPLICATION = '*';

    public CalculateModel() {
    }

    private Double operate(Double first, Double second, char operator) {
        switch (operator) {
            case CALCULATE_SUM:
                return first + second;
            case CALCULATE_SUBSTRACT:
                return first - second;
            case CALCULATE_MULTIPLICATION:
                return first * second;
            default:
                return first/second;
        }
    }

    public Double getResult(String value, Double lastResult) {
        Pattern full = Pattern.compile("(\\p{Digit}+)([+*/-]{1})(\\p{Digit}+)[=]{1}");
        Pattern unary = Pattern.compile("([+*/-]{1})(\\p{Digit}+)[=]{1}");
        Matcher mFull = full.matcher(value);
        Matcher mUnary = unary.matcher(value);

        if (mFull.find() && mFull.groupCount() == 3) {
            return operate(Double.valueOf(mFull.group(1)), Double.valueOf(mFull.group(3)), mFull.group(2).charAt(0));
        } else if (mUnary.find() && mUnary.groupCount() == 2) {
            return operate(lastResult, Double.valueOf(mUnary.group(2)), mUnary.group(1).charAt(0));
        } else {
            return .0;
        }
    }

    public boolean isOperator(String value) {
        return value.matches("[+*/=-]");
    }

    public boolean isNumber(String value) {
        String regex = "\\d";
        return value.matches(regex);
    }
}
