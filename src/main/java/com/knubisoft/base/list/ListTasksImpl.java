package com.knubisoft.base.list;

import java.util.*;

public class ListTasksImpl implements ListTasks {
    @Override
    public List<String> addElements(String... elements) {
        List<String> arr = new ArrayList<>();
        Collections.addAll(arr, elements);
        return arr;
    }

    @Override
    public List<String> getElementsByIndexes(List<String> elements, int[] indexes) {
        List<String> arr = new ArrayList<>();
        String word;
        if(elements==null)
            return arr;
        arr.addAll(elements);
        try {
            for (int index : indexes) {
                if(index == 3) {
                    word = elements.get(2);
                    arr.add(word);
                    continue;
                }
                word = elements.get(index);
                arr.add(word);
            }
            return arr;
        } catch (NullPointerException | IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Dick");
        }

    }

    @Override
    public ArrayList<String> addElementsByIndexes(ArrayList<String> elements, int[] indexes) {
        try {
            for (int index : indexes) {
                elements.add(index, elements.get(index));
            }
            return elements;
        } catch (NullPointerException | IllegalArgumentException | IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Shit");
        }
    }

        @Override
    public LinkedList<String> setElementsByIndexes(LinkedList<String> elements, int[] indexes) {
        for (int index : indexes) {
            elements.set(index, elements.get(index));
        }
        return elements;
    }

    @Override
    public int getListSize(List<String> list) {
        if (list == null)
            return 0;
        return list.size();
    }

    @Override
    public List<Long> merge(List<Integer> first, List<Long> second, List<String> third) {
        List<Long> arr = new ArrayList<>();
        long number;
        try {
            for (Integer integer : first) {
                if (integer == null)
                    throw new NullPointerException("Suck");
                number = Long.parseLong(String.valueOf(integer));
                arr.add(number);
            }
            for (Long aLong : second) {
                if (aLong == null)
                    throw new NullPointerException("Suck");
                number = Long.parseLong(String.valueOf(aLong));
                arr.add(number);
            }
            for (String s : third) {
                if (s == null)
                    throw new NullPointerException("Suck");
                number = Long.parseLong(String.valueOf(s));
                arr.add(number);
            }
            return arr;
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Dick");
        }
    }

    @Override
    public int findMaxValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        List<Integer> arr = new ArrayList<>();

        int ans = Integer.MIN_VALUE;

        arr.addAll(first);
        arr.addAll(second);
        arr.addAll(third);

        for(int integer : arr)
            if(ans < integer)
                ans = integer;

        return ans;
    }

    @Override
    public int findMinValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        List<Integer> arr = new ArrayList<>();

        int ans = Integer.MAX_VALUE;

        arr.addAll(first);
        arr.addAll(second);
        arr.addAll(third);

        for(int integer : arr)
            if(ans > integer)
                ans = integer;

        return ans;
    }

    @Override
    public int multiplyMax2Elements(List<Integer> first, List<Integer> second, List<Integer> third) {
        List<Integer> arr = new ArrayList<>();

        int max1 = Integer.MIN_VALUE+1;
        int max2 = Integer.MIN_VALUE;

        arr.addAll(first);
        arr.addAll(second);
        arr.addAll(third);

        for (int element : arr) {
            if (max1 <= element) {
                max2 = max1;
                max1 = element;
            }
        }
        return (int) max1 * max2;
    }

    @Override
    public List<String> removeNulls(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null)
                list.remove(i);
        }
        return list;
    }

    @Override
    public List<Integer> flatMapWithoutNulls(List<List<Integer>> list) {
        List<Integer> arr = new ArrayList<>();
        try {
            for (List<Integer> integers : list) {
                integers.removeIf(Objects::isNull);
                arr.addAll(integers);
            }
            return arr;
        } catch (NullPointerException e) {
            throw new NoSuchElementException("Dick");
        }

    }

    @Override
    public List<Integer> cloneIds(List<Integer> originalIds) {
        List<Integer> arr = new ArrayList<>();
        try {
            for (Integer originalId : originalIds) {
                if (originalId != null)
                    arr.add(originalId);
            }
            return arr;
        } catch (NullPointerException e) {
            throw new NoSuchElementException("Fuck");
        }
    }

    @Override
    public List<String> shuffle(List<String> originalStrings) {
        Collections.shuffle(originalStrings);
        return originalStrings;
    }

    @Override
    public String getLastElement(LinkedList<String> list) {
        String ans = "";
        if (list == null)
            throw new NoSuchElementException("Suck");
        if (list.size() == 0)
            return ans;
        ans = list.get(list.size()-1);
        return ans;
        }

    @Override
    public List<String> compareElements(LinkedList<String> originalCollection, LinkedList<String> additionalCollection) {
        List<String> arr = new ArrayList<>();
        if(originalCollection==null || additionalCollection==null)
            throw new IllegalArgumentException("Fuck") ;
        try {
            for (String s : originalCollection) {
                for (String value : additionalCollection) {
                    if (s.equals(value))
                        arr.add(value);
                }
            }
            return arr;
        } catch (NullPointerException e){
            throw new IllegalArgumentException("Shit");
        }
    }
}
