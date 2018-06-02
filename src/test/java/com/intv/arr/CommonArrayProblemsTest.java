package com.intv.arr;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonArrayProblemsTest {

    @Test
    public void testRotateArrayBy() throws Exception {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        int[] input = new int[]{0, 1, 2, 3, 4, 5};
        int[] output = new int[]{2, 3, 4, 5, 0, 1};
        arrayProblems.rotateArrayBy(input, 2);
        Assert.assertEquals(output, input, "Rotation did not work as expected");
        // should not get an NPE for this!!
        arrayProblems.rotateArrayBy(null, 2);
        Assert.assertNull(input, "Rotation did not work as expected");
    }

    @Test
    public void testPartitionArray() throws Exception {

    }

    @Test
    public void testPartitionArrayToSegregateNegativesZerosAndPositives() throws Exception {
    }

    @Test
    public void testPartitionArrayToArrangePositiveAndNegativeAlternatively() throws Exception {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        int[] input = new int[]{2, -2, 4, 7, 44, -23, -24, 22, -100};
        int[] output = new int[]{-100, -2, -24, -23, 44, 7, 4, 22, 2};
        arrayProblems.partitionArrayToArrangePositiveAndNegativeAlternatively(input);
        Assert.assertEquals(input, output, "Partition did not  work as expected!!");
    }

    @Test
    public void testPartitionArrayWithNegativesOnLeftAndPositivesAtRight() throws Exception {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        int[] input = new int[]{2, -2, 4, 7, 44, -23, -24, 22, -100};
        int[] output = new int[]{-100, -2, -24, -23, 44, 7, 4, 22, 2};
        arrayProblems.partitionArrayWithNegativesOnLeftAndPositivesAtRight(input);
        Assert.assertEquals(input, output, "Partition did not  work as expected!!");
        input = new int[]{};
        output = new int[]{};
        arrayProblems.partitionArrayWithNegativesOnLeftAndPositivesAtRight(input);
        Assert.assertEquals(input, output, "Partition did not work as expected !!!");
        arrayProblems.partitionArrayWithNegativesOnLeftAndPositivesAtRight(null);
        input = new int[]{100, 2, -99, 2, -33, -44, -9, -3, -9};
        output = new int[]{-9, -3, -99, -9, -33, -44, 2, 2, 100};
        arrayProblems.partitionArrayWithNegativesOnLeftAndPositivesAtRight(input);
        Assert.assertEquals(input, output, "Partition did not work as expected !!!");
        input = new int[]{-99, -33, -44, -9, -9};
        output = new int[]{-99, -33, -44, -9, -9};
        arrayProblems.partitionArrayWithNegativesOnLeftAndPositivesAtRight(input);
        Assert.assertEquals(input, output, "Partition did not work as expected !!!");
        input = new int[]{99, 33, 44, 9, 9};
        output = new int[]{99, 33, 44, 9, 9};
        arrayProblems.partitionArrayWithNegativesOnLeftAndPositivesAtRight(input);
        Assert.assertEquals(input, output, "Partition did not work as expected !!!");
    }

    @Test
    public void testLergestSubarraySum() throws Exception {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        final int[] input = new int[]{-2, 1, 3, 4, -10, 7};
        arrayProblems.lergestSubarraySum(input);
    }

    @Test
    public void testMaxProfilt() throws Exception {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        int[] prices = new int[]{2, 8, 4, 6, 7, 7};
        Assert.assertEquals(arrayProblems.maxProfilt(prices), 9, "Profit does not match!!");
        prices = new int[]{8, 7, 6, 5, 4, 3};
        Assert.assertEquals(arrayProblems.maxProfilt(prices), -1, "Profit does not match!!");
        prices = new int[]{8, 8, 8, 8, 8};
        Assert.assertEquals(arrayProblems.maxProfilt(prices), -1, "Profit does not match!!");
        prices = new int[]{2, 3, 2, 3, 2, 3, 2};
        Assert.assertEquals(arrayProblems.maxProfilt(prices), 3, "Profit does not match!!");
        prices = new int[]{1, 2, 3, 4, 5, 6};
        Assert.assertEquals(arrayProblems.maxProfilt(prices), 5, "Profit does not match!!");
    }

    @Test
    public void testFindMinimumDistanceBetweenTwoElements() throws Exception {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        int[] input = new int[]{2, 4, 5, 3, 2, 4, 2, 3, 9, 10};
        Assert.assertEquals(arrayProblems.findMinimumDistanceBetweenTwoElements(input, 2, 3), 1, "Expected minimum distance does not match!!");
        input = new int[]{9, 1, 1, 12, 9, 1, 1, 1, 9};
        Assert.assertEquals(arrayProblems.findMinimumDistanceBetweenTwoElements(input, 1, 9), 1, "Expected minimum distance does not match!!");
    }

    @Test
    public void testMergeOverlappingIntervals() throws Exception {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Integer[] input = new Integer[]{1, 3, 9, 11, 2, 7, 10, 100};
        Integer[] output = new Integer[]{1, 7, 9, 100};
        Assert.assertEquals(arrayProblems.mergeOverlappingIntervals(input), output, "Expected minimum distance does not match!!");
        input = new Integer[]{-1, 3, 9, 100, 2, 7, 10, 99};
        output = new Integer[]{-1, 7, 9, 100};
        Assert.assertEquals(arrayProblems.mergeOverlappingIntervals(input), output, "Expected minimum distance does not match!!");
        input = new Integer[]{1, 22, 9, 11, 9, 17, 10, 22};
        output = new Integer[]{1, 22};
        Assert.assertEquals(arrayProblems.mergeOverlappingIntervals(input), output, "Expected minimum distance does not match!!");
    }

    @Test
    public void findPairSumInArray() throws Exception {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        int[] input = new int[]{2, 4, 88, -6, 27, 12};
        int sum = 6;
        Assert.assertEquals(arrayProblems.findPairSumInArray(sum, input), Arrays.asList(-6, 12, 2, 4), "The output does not match !!!");
        input = new int[]{200, 42, 84, -923, 66, 12, -82, -97, 99};
        sum = 2;
        Assert.assertEquals(arrayProblems.findPairSumInArray(sum, input), Arrays.asList(-97, 99, -82, 84), "The output does not match !!!");
        Assert.assertEquals(arrayProblems.findPairSumInArray(sum, null), Arrays.asList(), "The output does not match !!!");
        input = new int[]{2, 4};
        sum = 2;
        Assert.assertEquals(arrayProblems.findPairSumInArray(sum, input), Arrays.asList(), "The output does not match !!!");
        input = new int[]{2, 4, 6};
        sum = 8;
        Assert.assertEquals(arrayProblems.findPairSumInArray(sum, input), Arrays.asList(2, 6), "The output does not match !!!");
        input = new int[]{2, 4, 2};
        sum = 4;
        Assert.assertEquals(arrayProblems.findPairSumInArray(sum, input), Arrays.asList(2, 2), "The output does not match !!!");
        input = new int[]{200, 42, 84, -923, 66, 12, -82, -97, 99};
        sum = 20000;
        Assert.assertEquals(arrayProblems.findPairSumInArray(sum, input), Arrays.asList(), "The output does not match !!!");
        input = new int[]{2, 2, 2, 2};
        sum = 4;
        Assert.assertEquals(arrayProblems.findPairSumInArray(sum, input), Arrays.asList(2, 2, 2, 2), "The output does not match !!!");
    }

    @Test
    public void findMostFrequentElementWithNull() {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        final int[] input = null;
        Assert.assertNull(arrayProblems.findMostFrequent(input), "For null input, output must be null !!!");
    }

    @Test
    public void findMostFrequentElementWithEmptyArray() {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        final int[] input = {};
        Assert.assertNull(arrayProblems.findMostFrequent(input), "For null input, output must be null !!!");
    }

    @Test
    public void findMostFrequentElementWithOneElementArray() {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        final int[] input = {10};
        Assert.assertNull(arrayProblems.findMostFrequent(input), "For null input, output must be null !!!");
    }

    @Test
    public void findMostFrequentElementWithTwoElementArray() {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        final int[] input = {10, 2};
        Assert.assertNull(arrayProblems.findMostFrequent(input), "Should return null, as the input contains just 2 elements!!");
    }

    @Test
    public void findMostFrequentElementWithUniqueElementArray() {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        final int[] input = {10, 2, 100, 97, 76, 45};
        Assert.assertNull(arrayProblems.findMostFrequent(input), "Should return null, as all are unique elements");
    }

    @Test
    public void findMostFrequentElementWithDuplicateElementsInArray() {
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        final int[] input = {10, 2, 100, 10, 20, 45, 10, 87, 66, 2, 10, 1023, 45, 66, 10, 102};
        Assert.assertEquals(arrayProblems.findMostFrequent(input), Integer.valueOf(10),"Most frequent element must be 10");
    }

    @Test
    public void findIntersectionWithFirstInputNull() {
        final int[] input1 = null;
        final int[] input2 = {};
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertNull(arrayProblems.findIntersection(input1, input2), "for either of the inputs being null or empty, the output must be null!!");
    }

    @Test
    public void findIntersectionWithSecondInputNull() {
        final int[] input1 = {};
        final int[] input2 = null;
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertNull(arrayProblems.findIntersection(input1, input2), "for either of the inputs being null or empty, the output must be null!!");
    }


    @Test
    public void findIntersectionWithBothInputNull() {
        final int[] input1 = null;
        final int[] input2 = null;
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertNull(arrayProblems.findIntersection(input1, input2), "for either of the inputs being null or empty, the output must be null!!");
    }

    @Test
    public void findIntersectionWithBothInputEmpty() {
        final int[] input1 = {};
        final int[] input2 = null;
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertNull(arrayProblems.findIntersection(input1, input2), "for either of the inputs being null or empty, the output must be null!!");
    }

    @Test
    public void findIntersectionWithTwoInputsOfSameSize() {
        final int[] input1 = {2, 1, 4, 9, 10, 102};
        final int[] input2 = {100, 4, 88, 1, 10002, 9};
        final int[] output = {1, 4, 9};
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertEquals(arrayProblems.findIntersection(input1, input2), output, "Expected output does not match");
    }


    @Test
    public void findIntersectionWithTwoInputsOfDifferentSize1() {
        final int[] input1 = {2, 1, 100, 4, 9, 49, 60};
        final int[] input2 = {60};
        final int[] output = {60};
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertEquals(arrayProblems.findIntersection(input1, input2), output,"Expected output does not match");
    }

    @Test
    public void findIntersectionWithTwoInputsOfDifferentSize2() {
        final int[] input1 = {785970, 77};
        final int[] input2 = {60, 110, 1023, 44, 23, 1, -10, 27, 68, 77, 10937, 45};
        final int[] output = {77};
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertEquals(arrayProblems.findIntersection(input1, input2), output,"Expected output does not match");
    }

    @Test
    public void testTwoArraysAreRotationOfOneAnotherWithNullInput() {
        final int[] input1 = null;
        final int[] input2 = {};
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertFalse(arrayProblems.isRotation(input1, input2), "For null or empty inputs, it should not be considered a rotation !!");
    }

    @Test
    public void testTwoArraysAreRotationOfOneAnotherWithEmptyInput() {
        final int[] input1 = {};
        final int[] input2 = {9, 1, 10};
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertFalse(arrayProblems.isRotation(input1, input2), "For null or empty inputs, it should not be considered a rotation !!");
    }

    @Test
    public void testTwoArraysAreRotationOfOneAnotherWithOneElementArray() {
        final int[] input1 = {1};
        final int[] input2 = {1};
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertTrue(arrayProblems.isRotation(input1, input2), "For 1 element array with identical element, the response should be true!!");
    }

    @Test
    public void testTwoArraysAreRotationOfOneAnotherWithOneElementUniqueArray() {
        final int[] input1 = {1};
        final int[] input2 = {2};
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertFalse(arrayProblems.isRotation(input1, input2), "For 1 element inputs with non-identical element, the response should be False!!");
    }

    @Test
    public void testTwoArraysAreRotationOfOneAnotherWithArraysOfDifferentSize() {
        final int[] input1 = {1, 2, 3};
        final int[] input2 = {3, 4, 5, 1, 2};
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertFalse(arrayProblems.isRotation(input1, input2), "For input of different size, the output should be false !!");
    }

    @Test
    public void testTwoArraysAreRotationOfOneAnotherWithValidInputOfSizeTwo() {
        final int[] input1 = {1, 2};
        final int[] input2 = {2, 1};
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertTrue(arrayProblems.isRotation(input1, input2), "For valid input, the outcome should be True !!");
    }

    @Test
    public void testTwoArraysAreRotationOfOneAnotherWithValidInputOfSizeSix() {
        final int[] input1 = {1, 2, 3, 4, 5, 6};
        final int[] input2 = {4, 5, 6, 1, 2, 3};
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertTrue(arrayProblems.isRotation(input1, input2), "For valid input, the outcome should be True !!");
    }

    @Test
    public void testTwoArraysAreRotationOfOneAnotherWithIdenticalInput() {
        final int[] input1 = {100, 200, 300};
        final int[] input2 = {100, 200, 300};
        final CommonArrayProblems arrayProblems = new CommonArrayProblems();
        Assert.assertFalse(arrayProblems.isRotation(input1, input2), "For identical input, the outcome should be True !!");
    }
}