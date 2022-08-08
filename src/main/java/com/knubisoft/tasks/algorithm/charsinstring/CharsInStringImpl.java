package com.knubisoft.tasks.algorithm.charsinstring;

import java.util.HashMap;
import java.util.Map;

public class CharsInStringImpl implements CharsInString {
    @Override
    public Map<Character, Integer> charactersCount(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character value = text.charAt(i);
            Integer count = map.get(value);
            if (value == ' ')
                continue;
            if (count == null){
                count = 1;
                map.put(value, count);
            } else {
                count += 1;
                map.put(value, count);
            }
        }
        return map;
    }
}
