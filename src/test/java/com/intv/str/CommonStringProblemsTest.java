package com.intv.str;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CommonStringProblemsTest {

    @Test
    public void testFindAllSubstrings() throws Exception {
        final CommonStringProblems problems = new CommonStringProblems();
        Assert.assertEquals(problems.findAllSubstrings(""), null, "For empty string, we should get null");
        Assert.assertEquals(problems.findAllSubstrings(null), null, "For null, we should get null");

        Assert.assertEquals(problems.findAllSubstrings("abc"), Arrays.asList("a", "ab", "abc", "b", "bc", "c"), "sub-string does not match expected !!!!");
        Assert.assertEquals(problems.findAllSubstrings("abcxyz"), Arrays.asList("a", "ab", "abc", "abcx", "abcxy", "abcxyz",  "b", "bc", "bcx", "bcxy", "bcxyz", "c", "cx",
                "cxy", "cxyz", "x", "xy", "xyz", "y", "yz", "z"),
                "sub-string does not match expected !!!!");
    }

    @Test
    public void testIsPalindrome() throws Exception {
        final CommonStringProblems problems = new CommonStringProblems();
        Assert.assertFalse(problems.isPalindrome(""), "For empty string, we should get false");
        Assert.assertFalse(problems.isPalindrome(null), "For null, we should get false");

        Assert.assertTrue(problems.isPalindrome("a"), "For one word string \"a\", it should be considered as a palindrome");
        Assert.assertTrue(problems.isPalindrome("madam"), "madam should be a palindrome");
        // check for case sensitive case
        Assert.assertTrue(problems.isPalindrome("Madam"), "Madam should be a palindrome");
        Assert.assertTrue(problems.isPalindrome("abba"), "abba should be a palindrome");
        Assert.assertTrue(problems.isPalindrome("AbBa"), "AbBa should be a palindrome");
        Assert.assertTrue(problems.isPalindrome("ABBA"), "ABBA should be a palindrome");
        Assert.assertTrue(problems.isPalindrome("aa"), "aa should be a palindrome");
        Assert.assertFalse(problems.isPalindrome("Let Bob tell"), "\"Let Bob tell\" should not be a palindrome");
        Assert.assertTrue(problems.isPalindrome("Able was I ere I saw Elba"), "\"Able was I ere I saw Elba\" should not be a palindrome");
        Assert.assertTrue(problems.isPalindrome("Never odd or even"), "\"Never odd or even\" should not be a palindrome");
        Assert.assertTrue(problems.isPalindrome("Madam, I'm Adam"), "\"Madam, I'm Adam\" should not be a palindrome");

    }
}