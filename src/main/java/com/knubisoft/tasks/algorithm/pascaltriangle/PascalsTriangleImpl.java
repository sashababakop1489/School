package com.knubisoft.tasks.algorithm.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleImpl implements PascalsTriangle {

    @Override
    public List<Integer> calculateLineOfPascalsTriangle(int lineNumber) {
        List<Integer> result = new ArrayList<>();

        int prev = 1;
        result.add(prev);

        for (int i = 1; i < lineNumber; i++) {
            int curr = (prev * (lineNumber - i)) / i;
            result.add(curr);
            prev = curr;
        }
        return result;
    }
}
