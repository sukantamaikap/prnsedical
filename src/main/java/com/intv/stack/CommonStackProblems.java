package com.intv.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: Document this class.
 */
public class CommonStackProblems {
    /**
     * Given an expression consisting of only parentheses, check if the expression is balanced or not.
     * Example [{()()}] is balanced, {{(}} - not balanced
     * @param expression
     */
    public boolean isParenthesesBalanced(final String expression) {
        if (expression == null || expression.length() == 0) {
            return Boolean.FALSE;
        }

        final Map<String, String> mapper = new HashMap<>();
        mapper.put("}", "{");
        mapper.put(")", "(");
        mapper.put("]", "[");

        final List<String> stack = new ArrayList<>();

        for (int i =0; i < expression.length(); i++) {
            String element = Character.toString(expression.charAt(i));
            if (mapper.containsKey(element)) {
                if (stack.size() == 0) {
                    return Boolean.FALSE;
                } else {
                    if (!(mapper.get(element).equals(stack.remove(stack.size() -1)))) {
                        return Boolean.FALSE;
                    }
                }
            } else {
                stack.add(element);
            }
        }
        return stack.size() == 0;
    }
}
