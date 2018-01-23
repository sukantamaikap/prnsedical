package com.gnrl.sort;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;


public class QuickSortTest {

    @Test
    public void testQuickSort() {
        final Integer[] elements = new Integer[]{20, 10, 1, 0, 100, 1001, 200, 201, 504, 204, 403};
        final QuickSort<Integer> quickSort = new QuickSort<>(elements);
        final Integer[] output = quickSort.sort();
        Arrays.sort(elements);
        Assert.assertEquals(elements, output, "Sort did not work as expected !!!");
    }

}