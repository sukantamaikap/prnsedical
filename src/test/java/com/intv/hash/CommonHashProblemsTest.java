package com.intv.hash;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonHashProblemsTest {

  @Test
  public void countPairs() throws Exception {
    final List<Integer> input1 = new LinkedList<>();
    input1.add(2);
    input1.add(4);
    input1.add(100);
    input1.add(8);
    input1.add(20);
    input1.add(3);
    final List<Integer> input2 = new LinkedList<>();
    input2.add(3);
    input2.add(2);
    input2.add(5);
    input2.add(7);
    input2.add(4);
    input2.add(6);
    int sum = 8;
    final CommonHashProblems hashProblems = new CommonHashProblems();
    Assert.assertEquals(
        hashProblems.countPairs(input1, input2, sum),
        Arrays.asList(3, 5, 4, 4, 2, 6),
        "Pair(s) do(es) not match !!");
    Assert.assertEquals(
        hashProblems.countPairs(null, null, sum), Arrays.asList(), "Pair(s) do(es) not match !!");
    Assert.assertEquals(
        hashProblems.countPairs(input1, null, sum), Arrays.asList(), "Pair(s) do(es) not match !!");
    input2.add(22);
    input2.add(-10);
    Assert.assertEquals(
        hashProblems.countPairs(input1, input2, sum),
        Arrays.asList(3, 5, 4, 4, 2, 6),
        "Pair(s) do(es) not match !!");
    input1.clear();
    input1.add(10);
    input1.add(4);
    input1.add(7);
    input2.clear();
    input2.add(3);
    input2.add(-3);
    sum = 7;
    Assert.assertEquals(
        hashProblems.countPairs(input1, input2, sum),
        Arrays.asList(4, 3, 10, -3),
        "Pair(s) do(es) not match !!");
  }

  @Test
  public void testFirstElementOccuringKTimes() {
    final CommonHashProblems hashProblems = new CommonHashProblems();
    int[] input = null;
    Assert.assertEquals(hashProblems.firstElementOccuringKTimes(input,2), -1, "For null or empty input, the output must be -1");
    input = new int[0];
    Assert.assertEquals(hashProblems.firstElementOccuringKTimes(input,2), -1, "For null or empty input, the output must be -1");
    input = new int[]{1, 2, 3, 4, 5, 6};
    Assert.assertEquals(hashProblems.firstElementOccuringKTimes(input,2), -1, "Expexcted output does not match!!");
    input = new int[]{1, 2, 1, 2, 1, 2};
    Assert.assertEquals(hashProblems.firstElementOccuringKTimes(input,2), 1, "Expexcted output does not match!!");
    input = new int[]{101, 22, 2, 34, 2, 34, 44, 101};
    Assert.assertEquals(hashProblems.firstElementOccuringKTimes(input,2), 101, "Expexcted output does not match!!");
    input = new int[]{101, 101, 101, 101, 101};
    Assert.assertEquals(hashProblems.firstElementOccuringKTimes(input,100), -1, "Expexcted output does not match!!");
    input = new int[]{1, 1, 1};
    Assert.assertEquals(hashProblems.firstElementOccuringKTimes(input,2), 1, "Expexcted output does not match!!");
    input = new int[]{1, 2, 8, 1, 2, 8};
    Assert.assertEquals(hashProblems.firstElementOccuringKTimes(input,2), 1, "Expexcted output does not match!!");
  }
}
