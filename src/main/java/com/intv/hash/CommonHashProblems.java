package com.intv.hash;

import java.util.*;

/** TODO: Document this class. */
public class CommonHashProblems {
  /**
   * Find pair(s) from both linked lists, which adds to sum as mentioned. Won't work for duplicate.
   *
   * @param first
   * @param second
   * @param sum
   * @return {@link List} of pair of numbers with sum
   */
  public List<Integer> countPairs(
      final List<Integer> first, final List<Integer> second, final int sum) {
    final List<Integer> pairs = new ArrayList<>();
    if (first == null || second == null || first.size() == 0 || second.size() == 0) {
      return pairs;
    }

    final Map<Integer, Integer> tmpMap = new HashMap<>();

    final Iterator<Integer> firstIterator = first.iterator();
    while (firstIterator.hasNext()) {
      tmpMap.put(firstIterator.next(), 0);
    }

    final Iterator<Integer> secondIterator = second.iterator();

    while (secondIterator.hasNext()) {
      final int num = secondIterator.next();
      if (tmpMap.containsKey(sum - num)) {
        pairs.add(sum - num);
        pairs.add(num);
        tmpMap.remove(sum - num);
      }
    }

    return pairs;
  }

  /**
   * First element occurring k times in an array
   *
   * Given an array of n integers. The task is to find the first element that occurs k number of times. If no element occurs k times the print -1. The distribution of integer elements could be in any range.
   *
   * Examples:
   * Input : {1, 7, 4, 3, 4, 8, 7},
   *         k = 2
   * Output : 7
   * Both 7 and 4 occur 2 times.
   * But 7 is the first that occurs 2 times.
   *
   * Input : {4, 1, 6, 1, 6, 4},
   *         k = 1
   * Output : -1
   * @param input
   * @param k
   * @return element if found, -1 otherwise
   */
  public int firstElementOccuringKTimes(final int[] input, final int k) {
    if (input == null || input.length == 0 || input.length < k || k <= 0) {
      return -1;
    }

    final Map<Integer, Integer> cache = new LinkedHashMap<>();
    for (int item : input) {
      if (cache.containsKey(item)) {
        cache.put(item, cache.get(item) + 1);
      } else {
        cache.put(item, 1);
      }
    }

    for (final Integer key : cache.keySet()) {
      if (cache.get(key) >= k) {
        return key;
      }
    }

    return -1;
  }
}
