package com.gnrl.srch;

import java.util.List;

public class BinarySearch<T extends Comparable<T>> {

    private List<T> items;

    public BinarySearch(final List<T> items) {
        this.items = items;
    }

    public boolean search(final T key) {
        int high = this.items.size() -1;
        int low = 0;

        while (low <= high) {
            int mid = (high + low) / 2;

            if(items.get(mid).equals(key)) {
                return Boolean.TRUE;
            }

            if (items.get(mid).compareTo(key) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return Boolean.FALSE;
    }
}
