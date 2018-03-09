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
}
