package com.prsa.cont.w2.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests for Dijkstra's two-stack evaluation tests
 */
public class EvaluateExpressionTest {

    @Test
    public void testEvaluateExpression() {
        int value = EvaluateExpression.evaluate("((1+2)*3)");
        Assert.assertEquals(Integer.valueOf(value), Integer.valueOf(9), "Expected value does not match");

        value = EvaluateExpression.evaluate("((1+9)/(5-3))");
        Assert.assertEquals(Integer.valueOf(value), Integer.valueOf(5), "Expected value does not match");

        value = EvaluateExpression.evaluate("(((1+9)*(5-3))-(1+2))");
        Assert.assertEquals(Integer.valueOf(value), Integer.valueOf(17), "Expected value does not match");

        value = EvaluateExpression.evaluate("((((1+9)*(5-3))-2)-10)");
        Assert.assertEquals(Integer.valueOf(value), Integer.valueOf(8), "Expected value does not match");
    }

}