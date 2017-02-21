package com.globant.counter.android.mvp.module.two.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author s.ruiz
 */

public class CalculateModel {

    private static final char CALCULATE_SUM = '+';
    private static final char CALCULATE_SUBSTRACT = '-';
    private static final char CALCULATE_MULTIPLICATION = '*';
    private static final String FULL_PATTER = "(\\p{Digit}+)([+*/-]{1})(\\p{Digit}+)[=]{1}";
    private static final String UNARY_PATTER = "([+*/-]{1})(\\p{Digit}+)[=]{1}";
    private static final String OPERATORS_MATCHER = "[+*/=-]";
    private static final String NUMBERS_MATCHER = "\\d";
    private static final String INVALID_OPERATION = "/0=";
    private static final String WELL_FORMED_OPERATION = "=";

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
                return first / second;
        }
    }

    public Double getResult(String value, Double lastResult) {
        Pattern full = Pattern.compile(FULL_PATTER);
        Pattern unary = Pattern.compile(UNARY_PATTER);
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
        return value.matches(OPERATORS_MATCHER);
    }

    public boolean isNumber(String value) {
        String regex = NUMBERS_MATCHER;
        return value.matches(regex);
    }

    public boolean isInvalidOp(String value) {
        return value.contains(INVALID_OPERATION);
    }

    public boolean isWellFormedOp(String value) {
        return value.contains(WELL_FORMED_OPERATION);
    }
}
