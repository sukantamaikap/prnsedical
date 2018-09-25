package com.intv.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
}
