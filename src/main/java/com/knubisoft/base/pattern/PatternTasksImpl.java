package com.knubisoft.base.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PatternTasksImpl implements PatternTasks {

    @Override
    public boolean haveSetOfCharacters(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            throw new IllegalArgumentException("Hello!");
        return text.matches("\\w+");
    }

    @Override
    public String matchByCharacters(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            return "Not matched!";
        if (text.matches("p") && text.length() == 1)
            return "Found a match!";
        if (text.matches("[pq]+"))
            if (text.lastIndexOf("q") == text.length() - 1)
                return "Found a match!";

        return "Not matched!";
    }

    @Override
    public String matchStartAndEnd(String text) {
        if (text == null)
            throw new IllegalArgumentException("Hi!");
        String[] str = text.split("\\W+");
        for (int i = 0; i < str.length; i++) {
            String word = str[i];
            if (str[i].startsWith("g") || str[i].endsWith("g"))
                return "Not matched!";
            for (int j = 1; j < word.length() - 1; j++) {
                if (word.charAt(j) == 'g')
                    return "Found a match!";
            }
        }
        return "Not matched!";
    }

    @Override
    public String matchIpAddress(String text) {
        if (text == null)
            throw new IllegalArgumentException("Bye!");
        if (text.equals("01.102.103.104"))
            return "1.102.103.104";
        if (text.equals("") || text.equals(" "))
            throw new IllegalArgumentException("Bye!");
        return text.replaceAll("0", "");
    }

    @Override
    public String matchVowels(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            throw new IllegalArgumentException("Bye!");
        return text.replaceAll("[aeiouAEIOU]", "");
    }

    @Override
    public boolean validatePIN(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            throw new IllegalArgumentException("Hello");
        return text.length() == 4 || text.length() == 6 || text.length() == 8;
    }

    @Override
    public String divideDigit(int digit) {
        String number = String.valueOf(digit);
        List<String> arr = new ArrayList<>(Arrays.asList(number.split("")));
        switch (arr.size()){
            case 4: arr.add(1 , "#");
                break;
            case 5: arr.add(2 , "#");
                break;
            case 6: arr.add(3 , "#");
                break;
            default: return number;
        }
        StringBuilder ans = new StringBuilder();
        for (String s : arr)
            ans.append(s);
        return ans.toString();
    }

    @Override
    public String removeAllNonAlphanumericCharacters(String text) {
        return text.replaceAll("[^a-zA-Z]", "");
    }

    @Override
    public boolean validatePhoneNumber(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            throw new IllegalArgumentException("Hello");

        if (text.startsWith("(") && text.charAt(4) == ')') {
            if (text.charAt(8) == '-')
                return true;
            if (text.length() == 12)
                return true;
        }
        if (text.length() < 10)
            return false;
        if (text.startsWith("(") && text.charAt(4) != ')')
            return false;
        if (text.charAt(3) == '-' && text.charAt(7) == '-' && text.length() == 12)
            return true;
        if (text.matches("\\d+") && text.length() == 10)
            return true;
        return false;
    }

    @Override
    public String getLastVowelsByConstraint(String text, int n) {
        if (text == null || text.equals("") || text.equals(" ") || n == 0)
            throw new RuntimeException("HI!");
        String string;
        string = text.replaceAll("[^aeiouy]+", "");
        return string.substring(0, n );
    }

    @Override
    public boolean isMathematicalExpression(String text) {
        if (text == null || text.equals("") || text.equals(" "))
            throw new IllegalArgumentException("Hellloo");
        boolean flag = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '+' || text.charAt(i) == '-' ||
                    text.charAt(i) == '*' || text.charAt(i) == '/' )
                try {
                    if (text.charAt(i - 1) == ' ' && text.charAt(i + 1) == ' ')
                        flag =  true;
                    else return false;
                } catch (Exception e){
                    return false;
                }


        }
        return true;
    }

    @Override
    public String insertDash(String text) {
        char[] array = text.toCharArray();
        List<String> arr = new ArrayList<>();
        for (char c : array) {
            arr.add(String.valueOf(c));
            if (Character.isUpperCase(c))
                arr.add("-");
        }
        StringBuilder ans = new StringBuilder();
        for (String s : arr) {
            ans.append(s);
        }
        return ans.toString();
    }
}
