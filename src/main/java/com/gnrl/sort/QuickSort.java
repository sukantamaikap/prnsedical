package com.gnrl.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Quick sort implementation
 */
public class QuickSort<T extends Comparable> {
    private T[] elements;

    public QuickSort(Object[] elements) {
        final List asList = Arrays.asList(elements);
        // need to be shuffled once for achieving average case : NlgN
        Collections.shuffle(asList);
        this.elements = (T[])asList.toArray();
    }

    public T[] sort() {
        this.sort(elements, 0, elements.length - 1);
    }

    private void sort(final T[] items, int low, int high) {
        if (high <= low) {
            return;
        }

        final int pivot = this.partition(items, low, high);
        this.sort(items, low, pivot - 1);
        this.sort(items, pivot + 1, high);
    }

    /**
     * This method takes first element as pivot, places the pivot element at its correct position in sorted array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot
     * @param items
     * @param low
     * @param high
     * @return rightmost element index
     */
    private int partition(T[] items, int low, int high) {
        final T pivot = items[0];
        return 1;
    }
}
