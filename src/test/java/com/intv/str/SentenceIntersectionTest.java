package com.intv.str;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by smaikap on 15/7/17.
 */
public class SentenceIntersectionTest {

    @Test
    public void testIntersectionBruteForce() {
        final SentenceIntersection sentenceIntersection = new SentenceIntersection();
        final List<String> list1 = Arrays.asList("I", "have", "been", "wrong", "about", "this", "all", "along");
        final List<String> list2 = Arrays.asList("She", "had", "been", "to", "the", "other", "side", "of", "this");
        final List<String> intersection = sentenceIntersection.getCommonWordsBruteForce(list1, list2);
    }

}