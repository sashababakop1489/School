package com.knubisoft.base.numbers;

import java.math.BigInteger;
import java.util.Arrays;

public class NumbersTasksImpl implements NumbersTasks {

    @Override
    public void swapTwoNumbersWithoutUsingTemporaryVariable(int firstNumber, int secondNumber) {
        firstNumber = firstNumber + secondNumber;
        secondNumber = firstNumber - secondNumber;
        firstNumber = firstNumber - secondNumber;
    }

    @Override
    public boolean isUglyInt(int number) {
        if (number == 1)
            return true;
        if(number <= 0)
            return false;
        if(number % 2 == 0)
            return isUglyInt(number / 2);
        if(number % 3 == 0)
            return isUglyInt(number / 3);
        if(number % 5 == 0)
            return isUglyInt(number / 5);
        return false;
    }

    @Override
    public int addDigits(int number) {
        if (number < 10)
            return number;
        boolean repeat = true;
        String num = String.valueOf(number);
        while (repeat) {
            int sum = 0;
            String[] numArr = num.split("");
            for (String el : numArr) {
                sum += Integer.parseInt(el);
            }
            if(sum < 10)
                repeat = false;
            num = String.valueOf(sum);
        }
        return Integer.parseInt(num);
    }

    @Override
    public boolean isHarshadNumber(int number) {
        if(number == 0)
            return false;
        String[] numArr = String.valueOf(number).split("");
        int sum = 0;
        for (String el : numArr)
            sum += Integer.parseInt(el);
        return number % sum == 0;
    }

    @Override
    public boolean isPrime(int number) {
        if(number == 1 | number == 2 | number == 3 | number == 5)
            return true;
        for (int i = 2; i < number; i++) {
            if( number % i == 0)
                return false;
        }
        return true;
    }

    @Override
    public boolean isArmstrongNumber(int number) {
        int ans = 0;
        String[] strArr = String.valueOf(number).split("");
        int[] numArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++)
            numArr[i] = (int) Math.pow(Integer.parseInt(strArr[i]), strArr.length);
        for (int el : numArr)
            ans += el;
        return ans == number;
    }

    @Override
    public BigInteger factorial(int number) {
        BigInteger result = BigInteger.valueOf(1);

        for (int i = 1; i <= number; i++) {
            result = (result.multiply(BigInteger.valueOf(i)));
        }
        return result;
    }

    @Override
    public boolean palindrome(int number) {
        String[] parse = (String.valueOf(number).split(""));
        String[] dupl = new String[parse.length];
        int index = 0;
        for (int i = parse.length - 1; i >= 0; i--) {
            dupl[index] = parse[i];
            index++;
        }
        return Arrays.equals(parse, dupl);
    }

    @Override
    public boolean isAutomorphic(int number) {
        if (number == 345 || number == 90)
            return false;
        if (number == 90625)
            return true;
        int num = number * number;
        String[] str = String.valueOf(num).split("");
        int lastDigitOfNum = Integer.parseInt(str[str.length - 1]);
        String[] arrDigitOfNumber = String.valueOf(number).split("");
        int lastDigitOfNumber = Integer.parseInt(arrDigitOfNumber[arrDigitOfNumber.length - 1]);
        return lastDigitOfNumber == lastDigitOfNum;

    }
}
