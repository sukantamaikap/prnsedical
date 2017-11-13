package com.intv.str;

import java.util.ArrayList;
import java.util.List;

/**
 Write a program to find the intersection between two lists of Strings.
 Do this with and without an optimized data structure and quantify the time difference as the input sizes of the two lists grow to bigger numbers.

 public ArrayList<String>  getCommonWords(ArrayList<String> list1, ArrayList<String> list2){ }
 */
public class SentenceIntersection {

    public SentenceIntersection() {
    }

    /**
     * Find intersection the bruteforce way
     * @param list1
     * @param list2
     * @return intersection of two lists
     */
    public List<String> getCommonWordsBruteForce(List<String> list1, List<String> list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        final List<String> intersection = new ArrayList<String>();
        for (final String word : list1) {
            if (list2.contains(word)) {
                intersection.add(word);
            }
        }
        return intersection;
    }

    public List<String> getCommonWords1(List<String> list1, List<String> list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        return null;
    }
}
