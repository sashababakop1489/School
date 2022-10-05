package com.knubisoft.tasks.algorithm.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SearchImplTest {
    private final SearchImpl search = new SearchImpl();

    @Test
    void binarySearchSuccess() {
        long[] arrayTest = {11, 12, 13, 14, 15, 16};

        assertEquals(2, search.binarySearch(arrayTest, 13));
        assertEquals(4, search.binarySearch(arrayTest, 15));
    }

    @Test
    void binarySearchFail() {
        long[] arrayTest = {};

        assertThrows(NullPointerException.class, () -> search.binarySearch(null, 0));
        assertThrows(NullPointerException.class, () -> search.binarySearch(arrayTest, 0));
    }

}
