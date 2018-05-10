package com.intv.linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Common linked list problems.
 */
public class CommonLinkedListProblems {
    /**
     * Find pair(s) from both linked lists, which adds to sum as mentioned.
     * @param first
     * @param second
     * @param sum
     * @return {@link List} of pair of numbers with sum
     */
    public List<Integer> countPairs(final LinkedList<Integer> first,
                                    final LinkedList<Integer> second,
                                    final int sum) {
        final List<Integer> pairs = new ArrayList<>();
        if (first == null || second == null || first.size() == 0 || second.size() == 0) {
            return pairs;
        }

        // sort both the lists
        Collections.sort(first);
        Collections.sort(second, Collections.reverseOrder());

        final Iterator<Integer> firstIterator = first.iterator();
        final Iterator<Integer> secondIterator = second.iterator();

        Integer numFirst = firstIterator.hasNext() ? firstIterator.next() : null;
        Integer numSecond = secondIterator.hasNext() ? secondIterator.next() : null;

        while (numFirst != null && numSecond != null) {
            if ((numFirst + numSecond) == sum) {
                pairs.add(numFirst);
                pairs.add(numSecond);
                numFirst = firstIterator.hasNext() ? firstIterator.next() : null;
                numSecond = secondIterator.hasNext() ? secondIterator.next() : null;
            }

            if ((numFirst != null && numSecond != null) && (numFirst + numSecond) > sum) {
                numSecond = secondIterator.hasNext() ? secondIterator.next() : null;
            }

            if ((numFirst != null && numSecond != null) && (numFirst + numSecond) < sum) {
                numFirst = firstIterator.hasNext() ? firstIterator.next() : null;
            }
        }

        return pairs;
    }

}
