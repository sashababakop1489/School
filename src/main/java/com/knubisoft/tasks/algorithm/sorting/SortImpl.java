package com.knubisoft.tasks.algorithm.sorting;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortImpl implements Sort {

    @Override
    public Map<Integer, List<Integer>> sortKeysAndValues(Map<Integer, List<Integer>> input) {
        input.entrySet().forEach(el ->el.getValue().sort(Integer::compareTo));
        return input;
    }

}
