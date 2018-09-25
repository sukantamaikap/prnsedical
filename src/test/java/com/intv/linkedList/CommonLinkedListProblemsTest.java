package com.intv.linkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonLinkedListProblemsTest {

  @Test
  public void countPairs() throws Exception {
    final LinkedList<Integer> input1 = new LinkedList<>();
    input1.add(2);
    input1.add(4);
    input1.add(100);
    input1.add(8);
    input1.add(20);
    input1.add(3);
    input1.add(3);
    final LinkedList<Integer> input2 = new LinkedList<>();
    input2.add(3);
    input2.add(2);
    input2.add(200);
    input2.add(5);
    input2.add(7);
    input2.add(4);
    input2.add(6);
    int sum = 8;
    final CommonLinkedListProblems linkedListProblems = new CommonLinkedListProblems();
    Assert.assertEquals(
        linkedListProblems.countPairs(input1, input2, sum),
        Arrays.asList(2, 6, 3, 5, 4, 4),
        "Pair(s) do(es) not match !!");
    Assert.assertEquals(
        linkedListProblems.countPairs(null, null, sum),
        Arrays.asList(),
        "Pair(s) do(es) not match !!");
    Assert.assertEquals(
        linkedListProblems.countPairs(input1, null, sum),
        Arrays.asList(),
        "Pair(s) do(es) not match !!");
    input2.add(22);
    input2.add(-10);
    Assert.assertEquals(
        linkedListProblems.countPairs(input1, input2, sum),
        Arrays.asList(2, 6, 3, 5, 4, 4),
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
        linkedListProblems.countPairs(input1, input2, sum),
        Arrays.asList(4, 3, 10, -3),
        "Pair(s) do(es) not match !!");
  }

  @Test
  public void pairSwap() throws Exception {
    final List<Integer> input = new LinkedList<>();
    input.add(1);
    input.add(2);
    input.add(3);
    input.add(4);
    input.add(5);
    final CommonLinkedListProblems linkedListProblems = new CommonLinkedListProblems();
    //        Assert.assertEquals(linkedListProblems);
  }
}
