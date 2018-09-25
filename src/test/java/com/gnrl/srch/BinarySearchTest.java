package com.gnrl.srch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinarySearchTest {

  @Test
  public void testBinarySearch() {
    final List<Integer> item = new ArrayList<>();
    IntStream.range(0, 10000)
        .forEach(
            n -> {
              item.add(n);
            });
    final BinarySearch<Integer> binarySearch = new BinarySearch<>(item);
    Assert.assertTrue(binarySearch.search(4), "Key 4 not found !!!");
    Assert.assertTrue(binarySearch.search(102), "Key 102394 not found !!!");
    Assert.assertTrue(binarySearch.search(1094), "Key 1094 not found !!!");
    Assert.assertFalse(binarySearch.search(-12344), "Key -12344 should not be found !!!");
    Assert.assertFalse(binarySearch.search(56878978), "Key 568748974 should not be found !!!");
    Assert.assertTrue(binarySearch.search(0), "Key 0 not found !!!");
    Assert.assertTrue(binarySearch.search(9999), "Key 10000 not found !!!");
  }
}
