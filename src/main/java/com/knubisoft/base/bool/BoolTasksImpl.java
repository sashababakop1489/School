package com.knubisoft.base.bool;

import java.util.Arrays;

public class BoolTasksImpl implements BoolTasks {

    @Override
    public Boolean isTrueAutobox(boolean value) {
        return Boolean.valueOf(value);
    }

    @Override
    public Boolean isFalseAutobox(boolean value) {
        return value;
    }

    @Override
    public boolean isTrueUnbox(Boolean value) {
        return value.booleanValue();
    }

    @Override
    public Boolean isFalseUnbox(boolean value) {
        return value;
    }

    @Override
    public boolean andFunction(int digit, String string) {
        if (string == null)
            return false;
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (Exception e){
            return false;
        }
        return digit == number;
    }

    @Override
    public boolean orFunction(int digit, String string) {
        if (string == null || string.equals(" "))
            return false;
        int number;
        try {
           number = Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return digit == Integer.parseInt(string);
    }

    @Override
    public boolean andComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int range) {
        if(generatedFirstDigit == generatedSecondDigit && range == 3)
            return true;
        return generatedFirstDigit == generatedSecondDigit && range == 5;
    }

    @Override
    public boolean orComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int generatedThirdDigit, int range) {
        if (generatedFirstDigit == generatedSecondDigit || generatedFirstDigit == generatedThirdDigit)
            if (range == 3)
                return true;
        if (generatedFirstDigit == generatedSecondDigit || generatedFirstDigit == generatedThirdDigit)
            return range == 5;
        return false;
    }

    @Override
    public boolean isSameSizeArray(Object[] firstArray, Object... secondArray) {
        if (firstArray == null || secondArray == null)
            return false;
        String first = Arrays.toString(firstArray);
        String second = Arrays.toString(secondArray);
        return first.length() == second.length();
    }

    @Override
    public boolean isSameCharactersCount(String username, String name, int maxLength) {
        if (username == null || name == null)
            return false;
        if (username.equals("") || name.equals("") || maxLength == 0)
            return false;
        return username.length() == maxLength - 1 && name.length() == maxLength - 1;
    }
}
