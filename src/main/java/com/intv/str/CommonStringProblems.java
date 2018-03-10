package com.intv.str;

import java.util.ArrayList;
import java.util.List;

/**
 * All common string interview problems
 */
public class CommonStringProblems {

    /**
     * find all substrings for a string. Example : for String "abc" all possible substrings are : [a, ab, abc, b, bc, c]
     * O(n^2)
     * @param process
     * @return {@link List} of {@link String} for sub strings
     */
    public List<String> findAllSubstrings(final String process) {
        if (process == null || process.length() == 0) {
            return null;
        }

        final List<String> subs = new ArrayList<>();
        for (int i = 0; i < process.length(); i++) {
            subs.add(Character.toString(process.charAt(i)));
            final StringBuilder subsBuilder = new StringBuilder(Character.toString(process.charAt(i)));
            for (int j = i + 1; j < process.length(); j++) {
                subsBuilder.append(Character.toString(process.charAt(j)));
                subs.add(subsBuilder.toString());
            }
        }
        System.out.println("Substring found : " + subs.toString());
        return subs;
    }

    /**
     * Given a string, check if it is palindrome
     * O(n)
     * @param input
     * @return true if is palindrome, false otherwise
     */
    public boolean isPalindrome(final String input) {
        if (input == null || input.length() == 0) {
            return Boolean.FALSE;
        }

        // a string with 1 character is always palindrome
        if (input.length() == 1) {
            return Boolean.TRUE;
        }

        for (int i = 0, j = input.length() -1; i < j; i++, j--) {
            if (!Character.toString(input.charAt(i)).equalsIgnoreCase(Character.toString(input.charAt(j)))) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    /**
     * find all the indices where matching pattern is found
     * @param input
     * @param pattern
     * O(m+n)
     * @return
     */
    public List<Integer> naivePatternMatch(final String input, final String pattern) {
        if (pattern ==null || pattern.length() ==0) {
            return null;
        }
        final List<Integer> matchingIndecis = new ArrayList<>();
        for (int i = 0; i < (input.length() + 1 - pattern.length()); i++) {
            if (input.charAt(i) == pattern.charAt(0)) {
                int k =i;
                boolean found = Boolean.TRUE;
                int j = 0;
                for (; j < pattern.length() && k < input.length(); j++, k++) {
                    if (input.charAt(k) != pattern.charAt(j)) {
                        found = Boolean.FALSE;
                        break;
                    }
                }

                if (found) {
                    matchingIndecis.add(i);
                }
            }
        }
        System.out.println("Matching indices found : " + matchingIndecis.toString());

        return matchingIndecis;
    }

    /**
     * Find the longest prefix and suffix from a string. Example: abcabc -> abc | abcabca-> abca | aaaa-> aaa
     * The solution is to build a window n, run between 0 to (length - n) and 1 to lenght
     * match character from the beginning, break if any character does not match for the loop and increase n by 1
     * The order of comparison should go like this
     * 0 -> length-1 and 1 to length
     * 0 -> length-2 and 2 to length
     * 0 -> length-3 and 3 to length
     * 0 -> length-4 and 4 to length
     * and so on till the boundary conditions are true.
     * O(n) 
     * @param input
     * @return longest common substring
     */
    public String longestCommonPrefixAndSuffix(final String input) {
        if (input ==null || input.length() ==0) {
            return null;
        }

        int subWindow = 1;
        for (int i = 0; i < input.length() - subWindow ; subWindow++) {
            boolean found = Boolean.TRUE;
            if (input.charAt(i) == input.charAt(subWindow)) {
                for (int j = i, k = subWindow; k < input.length() && j < input.length() - subWindow; j++, k++ ) {
                    if (input.charAt(j) != input.charAt(k)) {
                        found = Boolean.FALSE;
                        break;
                    }
                }

                if (found){
                    return input.substring(i, input.length() - subWindow);
                }
            }
        }
        return "";
    }
}
