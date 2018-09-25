package com.intv.str;

import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonStringProblemsTest {

  @Test
  public void testFindAllSubstrings() throws Exception {
    final CommonStringProblems problems = new CommonStringProblems();
    Assert.assertEquals(
        problems.findAllSubstrings(""), null, "For empty string, we should get null");
    Assert.assertEquals(problems.findAllSubstrings(null), null, "For null, we should get null");

    Assert.assertEquals(
        problems.findAllSubstrings("abc"),
        Arrays.asList("a", "ab", "abc", "b", "bc", "c"),
        "sub-string does not match expected !!!!");
    Assert.assertEquals(
        problems.findAllSubstrings("abcxyz"),
        Arrays.asList(
            "a", "ab", "abc", "abcx", "abcxy", "abcxyz", "b", "bc", "bcx", "bcxy", "bcxyz", "c",
            "cx", "cxy", "cxyz", "x", "xy", "xyz", "y", "yz", "z"),
        "sub-string does not match expected !!!!");
  }

  @Test
  public void testIsPalindrome() throws Exception {
    final CommonStringProblems problems = new CommonStringProblems();
    Assert.assertFalse(problems.isPalindrome(""), "For empty string, we should get false");
    Assert.assertFalse(problems.isPalindrome(null), "For null, we should get false");

    Assert.assertTrue(
        problems.isPalindrome("a"),
        "For one word string \"a\", it should be considered as a palindrome");
    Assert.assertTrue(problems.isPalindrome("madam"), "madam should be a palindrome");
    // check for case sensitive case
    Assert.assertTrue(problems.isPalindrome("Madam"), "Madam should be a palindrome");
    Assert.assertTrue(problems.isPalindrome("abba"), "abba should be a palindrome");
    Assert.assertTrue(problems.isPalindrome("AbBa"), "AbBa should be a palindrome");
    Assert.assertTrue(problems.isPalindrome("ABBA"), "ABBA should be a palindrome");
    Assert.assertTrue(problems.isPalindrome("aa"), "aa should be a palindrome");
    Assert.assertFalse(
        problems.isPalindrome("Let Bob tell"), "\"Let Bob tell\" should not be a palindrome");
    Assert.assertTrue(
        problems.isPalindrome("Able was I ere I saw Elba"),
        "\"Able was I ere I saw Elba\" should not be a palindrome");
    Assert.assertTrue(
        problems.isPalindrome("Never odd or even"),
        "\"Never odd or even\" should not be a palindrome");
    Assert.assertTrue(
        problems.isPalindrome("Madam, I'm Adam"), "\"Madam, I'm Adam\" should not be a palindrome");
  }

  @Test
  public void testNaivePatternMatch() throws Exception {
    final CommonStringProblems problems = new CommonStringProblems();
    Assert.assertEquals(
        problems.naivePatternMatch("abcdef", "abc"),
        Arrays.asList(0),
        "Expected outcome does not match!!");
    Assert.assertEquals(
        problems.naivePatternMatch("aaaaaa", "aa"),
        Arrays.asList(0, 1, 2, 3, 4),
        "Expected outcome does not match!!");
    Assert.assertEquals(
        problems.naivePatternMatch("abcdef", "def"),
        Arrays.asList(3),
        "Expected outcome does not match!!");
    Assert.assertEquals(
        problems.naivePatternMatch("abcdef", "de"),
        Arrays.asList(3),
        "Expected outcome does not match!!");
    Assert.assertEquals(
        problems.naivePatternMatch("abcdef", "efg"),
        Arrays.asList(),
        "Expected outcome does not match!!");
    Assert.assertEquals(
        problems.naivePatternMatch("abcdef", ""), null, "Expected outcome does not match!!");
  }

  @Test
  public void testCommonPrefixSuffix() throws Exception {
    final CommonStringProblems problems = new CommonStringProblems();
    Assert.assertEquals(
        problems.longestCommonPrefixAndSuffix("abcabc"),
        "abc",
        "Expected common suffix prefix does not match");
    Assert.assertEquals(
        problems.longestCommonPrefixAndSuffix("acacac"),
        "acac",
        "Expected common suffix prefix does not match");
    Assert.assertEquals(
        problems.longestCommonPrefixAndSuffix("aaaaa"),
        "aaaa",
        "Expected common suffix prefix does not match");
    Assert.assertEquals(
        problems.longestCommonPrefixAndSuffix("abcde"),
        "",
        "Expected common suffix prefix does not match");
    Assert.assertEquals(
        problems.longestCommonPrefixAndSuffix(null),
        null,
        "Expected common suffix prefix does not match");
    Assert.assertEquals(
        problems.longestCommonPrefixAndSuffix(""),
        null,
        "Expected common suffix prefix does not match");
  }

  @Test
  public void testFindFirstNonRepeatingCharacterWithEmptyInput() {
    final CommonStringProblems problems = new CommonStringProblems();
    Assert.assertNull(
        problems.findFirstNonRepeatingCharacter(""), "For empty input, output should be null!!");
  }

  @Test
  public void testFindFirstNonRepeatingCharacterWithNullInput() {
    final CommonStringProblems problems = new CommonStringProblems();
    Assert.assertNull(
        problems.findFirstNonRepeatingCharacter(null), "For null input, output should be null!!");
  }

  @Test
  public void testFindFirstNonRepeatingCharacterWithAllIdenticalCharacters() {
    final CommonStringProblems problems = new CommonStringProblems();
    Assert.assertNull(
        problems.findFirstNonRepeatingCharacter("aaaaaa"),
        "For all identical character input, output should be null!!");
  }

  @Test
  public void testFindFirstNonRepeatingCharacterWithTwoIdenticalCharacters() {
    final CommonStringProblems problems = new CommonStringProblems();
    Assert.assertNull(
        problems.findFirstNonRepeatingCharacter("aaaaaabb"),
        "For all identical character input, output should be null!!");
  }

  @Test
  public void testFindFirstNonRepeatingCharacterWithSingleIdenticalCharacter() {
    final CommonStringProblems problems = new CommonStringProblems();
    Assert.assertEquals(
        problems.findFirstNonRepeatingCharacter("aaaaaabcbaa"),
        "c",
        "Expected outcome should be c!!");
  }

  @Test
  public void testFindFirstNonRepeatingCharacterWithMultipleIdenticalCharacter() {
    final CommonStringProblems problems = new CommonStringProblems();
    Assert.assertEquals(
        problems.findFirstNonRepeatingCharacter("aaaaaabcbnaaq"),
        "c",
        "Expected outcome should be c!!");
  }
}
