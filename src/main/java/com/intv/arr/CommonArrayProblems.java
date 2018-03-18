package com.intv.arr;

import java.util.*;

public class CommonArrayProblems {

    /**
     * Rotate right any array by predefined number
     * @param arr
     * @param by
     */
    public void rotateArrayBy(final int[] arr, final int by) {
        if (arr == null) {
            return;
        }
        // new index after move ( i + by ) % arr.length
        // i is the current index - but this approach has other challenges
        for (int i = 0; i < by; i++) {
            this.rotateLeftByOne(arr);
        }
    }

    private void rotateLeftByOne(final int[] arr) {
        int i = 0;
        int tmp = arr[i];
        for (; i < arr.length -1; i++) {
            arr[i] = arr[i+1];
        }
        arr[i] = tmp;
    }

    /**
     * An array contains both positive and negative numbers in random order. Rearrange the array elements so that
     * positive and negative numbers are placed alternatively. Number of positive and negative numbers need not be equal.
     * If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear
     * in the end of the array.
     * For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
     */
    public void partitionArrayToArrangePositiveAndNegativeAlternatively(final int[] arr) {
        if (arr.length == 1) {
            return;
        }
        // partition the array so that all positive numbers are towards the right and all negative numbers are towards the left
        // assumption : none of the elements in the array are 0
        this.partitionArrayWithNegativesOnLeftAndPositivesAtRight(arr);

        // find the index of the first +ve number
        int positiveIndex =0;
        while(arr[positiveIndex] < 0) {
            positiveIndex++;
        }

        int marker = positiveIndex;
        for (int i = 0; positiveIndex < arr.length;) {
            int tmp = arr[i];
            arr[i] = arr[positiveIndex];
            arr[positiveIndex] = tmp;
            i += 2;
            positiveIndex += 2;
        }

        System.out.println("Array after alternate partitioning : " + Arrays.toString(arr));
    }

    /**
     * partition an array such that all -ve numbers are on the left and all the postives are on right
     * @param arr
     * @return index of the last
     */
    public void partitionArrayWithNegativesOnLeftAndPositivesAtRight(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int i = 0;
        // partition the array so that all positive numbers are towards the right and all negative numbers are towards the left
        // assumption : none of the elements in the array are 0
        for (int j = arr.length - 1; i < j;) {
            if (arr[i] > 0 && arr[j] < 0) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            } else if (arr[i] < 0) {
                i++;
            } else if (arr[j] > 0) {
                j--;
            }
        }
        System.out.println("Partitioned array : " + Arrays.toString(arr));
    }

    public void partitionArrayToSegregateNegativesZerosAndPositives(final int[] arr) {

    }

    /**
     * Find the largest contiguous sub-array such that the sum of this sub-array elements is the highest among all elements.
     * @param arr
     * Does not work for array with all -ve numbers !!!
     */
    public int lergestSubarraySum(final int[] arr) {
        int size = arr.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + arr[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        System.out.println(max_so_far);
        return max_so_far;
    }

    /**
     * Dynamic programming !
     * n a daily share trading, a buyer buys shares in the morning and sells it on same day. If the trader is allowed to
     * make at most 2 transactions in a day, where as second transaction can only start after first one is complete
     * (Sell->buy->sell->buy). Given stock prices throughout day, find out maximum profit that a share trader could have made.
     * @return max profit as int, -1 if no profit is possible
     */
    public int maxProfilt(final int[] prices) {
        return -1;
    }

    /**
     * Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[].
     * The array might also contain duplicates.
     * Assumption : both x and y are different and present in arr[].
     * @param arr
     * @param a : start
     * @param b : end
     * @return min distance between a and b
     */
    public int findMinimumDistanceBetweenTwoElements(final int[] arr, final int a, final int b) {
        int startIndex = -1, endIndex = -1, min = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                startIndex = i;
            } else if (arr[i] == b) {
                endIndex = i;
            }

            if (startIndex != -1 && endIndex != -1) {
                if (min == -1 || min > (endIndex - startIndex)) {
                    min = endIndex - startIndex;
                }
                startIndex = -1;
                endIndex = -1;
            }
        }

        return min;
    }

    /**
     * Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only
     * mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity.
     * For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals {1,3} and {2,4} overlap with each other,
     * so they should be merged and become {1, 4}. Similarly {5, 7} and {6, 8} should be merged and become {5, 8}
     * @param arr - starting from  index 0, each pair is a range
     * @return 1 array with all merged ranges
     */
    public Integer[] mergeOverlappingIntervals(final Integer[] arr) {
        if (arr == null || arr.length % 2 != 0) {
            // invalid input !!!
            return null;
        }

        if (arr.length == 2) {
            return arr;
        }

        final boolean[] visited = new boolean[arr.length];
        final List<Integer> finalRange = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            int min = arr[i], max = arr[++i];

            for (int j = i + 2; j < arr.length; j++) {
                if (!visited[j]) {
                    if (min < arr[j] && arr[j] < max && min < arr[j + 1] && arr[j + 1] < max) {
                        this.markVisited(visited, j);
                    } else if (min < arr[j] && arr[j] < max && arr[j + 1] > max) {
                        max = arr[j+1];
                        this.markVisited(visited, j);
                    }
                }
            }

            finalRange.add(min);
            finalRange.add(max);
        }

        System.out.println("For input : " + Arrays.toString(arr) + " the merge range is : " + finalRange.toString());
        return finalRange.toArray(new Integer[finalRange.size()]);
    }

    private void markVisited(final boolean[] arr, int index) {
        arr[index] = Boolean.TRUE;
        arr[index + 1] = Boolean.TRUE;
    }
}
