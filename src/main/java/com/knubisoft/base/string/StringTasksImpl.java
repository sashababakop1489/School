package com.knubisoft.base.string;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class StringTasksImpl implements StringTasks {
    @Override
    public String reverseString(String original) {
        if(original == null)
            throw new IllegalArgumentException("Hello!");
        String result = "";
        for (int i = 0; i < original.length(); i++) {
        result = original.charAt(i) + result;
    }
        return result;
}

    @Override
    public String insertStringInMiddle(String original, String toInsert) {
        if (original == null || original.equals("") || toInsert == null || toInsert.equals(""))
            throw new IllegalArgumentException("Hi!");
        StringBuilder str = new StringBuilder(original);
        str.insert(original.length() / 2,toInsert);
        return str.toString();
    }

    @Override
    public String insertSymbolInString(String original, char toInsert, int position) {
        if (original == null || position >= original.length() || position < 0)
            throw new IllegalArgumentException("Hello");
        StringBuilder str = new StringBuilder(original);
        str.insert(position,toInsert);
        return str.toString();
    }

    @Override
    public String appendToString(StringBuilder original, String toAppend) {
        if (original == null || original.isEmpty() || toAppend == null)
            throw new NoSuchElementException("Hi");
        return original + toAppend;
    }

    @Override
    public boolean isPalindrome(String palindrome) {
        String result = "";
        for (int i = 0; i < palindrome.length(); i++) {
            result = palindrome.charAt(i) + result;
        }
        return result.equals(palindrome);
    }

    @Override
    public boolean hasLowerCase(String str) {
        if (str == null)
            throw new IllegalArgumentException("Hello");
        return str.equals(str.toLowerCase());
    }

    @Override
    public String uniqueCharacters(String str) {
        if (str == null)
            throw new IllegalArgumentException("Hello");
        String[] arrStr = str.split("");
        String buffer = "";
        for (int j = 0; j < str.length(); j++) {
            buffer += str.charAt(j);
            for (int i = 0; i < str.length(); i++) {
                if (j == i)
                    continue;
                if (arrStr[j].equalsIgnoreCase(arrStr[i])) {
                    buffer = buffer.replace(arrStr[j],"");
                    break;
                }
            }
        }
        return buffer;
    }

    @Override
    public String removeAllCharacters(String str, char charToRemove) {
        if (str == null)
            throw new IllegalArgumentException("Hello");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != charToRemove)
               ans.append(str.charAt(i));
        }
        return ans.toString();
    }

    @Override
    public String toCamelCase(String str) {
        if (str == null || str.equals(""))
            throw new IllegalArgumentException("Hello");
        String[] arrStr = str.split("");
        String ans = "";
        for (int i = 0; i < arrStr.length; i++) {
            if(i == 0) {
                ans += arrStr[i].toLowerCase();
                continue;
            }

            if (arrStr[arrStr.length - 1].equals("-") | arrStr[arrStr.length - 1].equals("_"))
                continue;
            if (arrStr[i].equals("-") | arrStr[i].equals("_") |  arrStr[i].equals(" "))
                arrStr[i+1] =  arrStr[i+1].toUpperCase();
            ans += arrStr[i];
        }
        ans = ans.replaceAll("-", "");
        ans = ans.replaceAll("_", "");
        ans = ans.replaceAll(" ", "");

        return ans;
    }

    @Override
    public String getCountRepeatableString(String str) {
        if (str == null)
            throw new IllegalArgumentException("???");
        return null;
    }

    @Override
    public String sortStringCharactersAsc(String str) {
        if (str == null)
            throw new IllegalArgumentException("Hi");
        String[] arrStr = str.split("");
        Arrays.sort(arrStr);
        String ans = "";
        for (String el : arrStr)
            ans += el;
        return ans;
    }
}
