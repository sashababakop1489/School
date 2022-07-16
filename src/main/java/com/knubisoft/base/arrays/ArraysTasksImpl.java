package com.knubisoft.base.arrays;

public class ArraysTasksImpl implements ArraysTasks {

    @Override
    public int[] reverse(int[] array) {
       int[] ans = new int[array.length];
       int index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            ans[index] = array[i];
            index++;
        }
        return ans;
    }

    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {
        int[] ans = new int[array1.length + array2.length];
        int index = 0;
        for (int j : array1) {
            ans[index] = j;
            index++;
        }
        for (int j : array2) {
            ans[index] = j;
            index++;
        }
        return ans;
    }

    @Override
    public int[] findMax3InArray(int[] array) {

        if (array.length < 3){
            return array;
        }

        int[] ans = new int[3];
        int count = 0;
        while (count != 3){
            int max = Integer.MIN_VALUE;
            for (int j : array) {
                if (j > max)
                    max = j;
            }

            ans[count] = max;
            count++;

            for (int i = 0; i < array.length; i++) {
                if (array[i] == max)
                    array[i] = Integer.MIN_VALUE;
            }
        }
        return ans;
    }

    @Override
    public int findLongestIncreasingContinuesSubsequence(int[] array) {
        int ans = 0;
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1])
                count++;
            if(ans < count)
                ans = count;
            else if(array[i] <= array[i - 1])
                count = 1;
        }
        return ans;
    }

    @Override
    public int sumOfAllUniqueElements(int[] array) {
        int[] arr = new int[array.length];
        System.arraycopy(array, 0, arr, 0, array.length);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == number) {
                    arr[j] = 0;
                }
            }
        }
        for (int num : arr)
            sum += num;
        return sum;
    }

    @Override public int[] moveZeroes(int[] array) {
        int count = 0;
        int[] newArr = new int[array.length];
            for (int j = 0; j < array.length; j++) {
                if (array[j] != 0)
                    newArr[j-count] = array[j];
                else count++;
            }
        return newArr;
    }

    @Override
    public int findFinalValue(int[] nums, int original) {
        int ans = original;
        boolean repeat = true;
        while (repeat) {
            repeat = false;
            for (int num : nums) {
                if (num == ans) {
                    ans *= 2;
                    repeat = true;
                }
            }
        }
        return ans;
    }

    @Override
    public String longestCommonPrefix(String[] words) {
        if(words.length==0)
            return "";

        String prefix = words[0];
        boolean flag = true;
        boolean repeat = true;
        while (repeat) {
            repeat = false;
            for (int i = 1; i < words.length; i++) {
                flag = false;
                    if (words[i].startsWith(prefix)) {
                        flag = true;
                    } else {
                        prefix = prefix.substring(0, prefix.length() - 1);
                        repeat = true;
                        break;
                    }
            }
            if (!flag)
                repeat = true;
        }
        return prefix.toString();
    }

    @Override
    public int missingNumber(int[] array) {
        int ans = 0;
        boolean repeat = true;
        while (repeat) {
            repeat = false;
            for (int num : array) {
                if (ans == num){
                    ans += 1;
                    repeat = true;
                }
            }
        }
        return ans;
    }

    @Override
    public boolean containsDuplicate(int[] array) {
        int number = array[0];
        boolean repeat = true;
        while (repeat) {
            repeat = false;
            for (int i = 1; i < array.length; i++) {
                if (number == array[i]) {
                    return true;
                }
            }
            number = array[+1];
        }
        return false;
    }
}
