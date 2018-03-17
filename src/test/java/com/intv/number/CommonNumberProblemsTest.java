package com.intv.number;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CommonNumberProblemsTest {

    @Test
    public void testSieveOfEratosthenes() throws Exception {
        final CommonNumberProblems numberProblems = new CommonNumberProblems();
        Assert.assertEquals(numberProblems.sieveOfEratosthenes(100), Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97),"Expected prime numbers does not match !!!");
        Assert.assertEquals(numberProblems.sieveOfEratosthenes(101), Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101),"Expected prime numbers does not match !!!");
        Assert.assertEquals(numberProblems.sieveOfEratosthenes(10), Arrays.asList(2, 3, 5, 7), "Prime numbers does not match expected !!!");
        Assert.assertEquals(numberProblems.sieveOfEratosthenes(1), null, "Prime numbers does not match expected !!!");
        Assert.assertEquals(numberProblems.sieveOfEratosthenes(2), Arrays.asList(2), "Prime numbers does not match expected !!!");
    }
}