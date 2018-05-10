package com.intv.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Copyright 2018 Mobile Iron, Inc.
 * All rights reserved.
 */
public class CommonStackProblemsTest {

    @Test
    public void testIsParenthesesBalancedEmptyExpression() {
        final CommonStackProblems stackProblems = new CommonStackProblems();
        Assert.assertFalse(stackProblems.isParenthesesBalanced(""), "Empty string as input should give invalid expression!!");
    }

    @Test
    public void testIsParenthesesBalancedNullExpression() {
        final CommonStackProblems stackProblems = new CommonStackProblems();
        Assert.assertFalse(stackProblems.isParenthesesBalanced(null), "Null as input should give invalid expression!!");
    }

    @Test
    public void testIsParenthesesBalancedInvalidExpression() {
        final CommonStackProblems stackProblems = new CommonStackProblems();
        Assert.assertFalse(stackProblems.isParenthesesBalanced("[{(}]()"), "Incomplete expression as input should give invalid expression!!");
    }


    @Test
    public void testIsParenthesesBalancedValidExpression() {
        final CommonStackProblems stackProblems = new CommonStackProblems();
        Assert.assertTrue(stackProblems.isParenthesesBalanced("[{}]()"), "Complete expression as input should give valid expression!!");
    }

}