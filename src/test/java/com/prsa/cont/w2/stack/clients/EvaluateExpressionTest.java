package com.prsa.cont.w2.stack.clients;

import org.testng.Assert;
import org.testng.annotations.Test;

/** Tests for Dijkstra's two-stack evaluation tests */
public class EvaluateExpressionTest {

  @Test
  public void testEvaluateExpression() {
    long value = EvaluateExpression.evaluate("( ( 1 + 2 ) * 3 )");
    Assert.assertEquals(Long.valueOf(value), Long.valueOf(9), "Expected value does not match");

    value = EvaluateExpression.evaluate("( ( 1 + 9 ) / ( 5 - 3 ) )");
    Assert.assertEquals(Long.valueOf(value), Long.valueOf(5), "Expected value does not match");

    value = EvaluateExpression.evaluate("( ( ( 1 + 9 ) * ( 5 - 3 ) ) - ( 1 + 2 ) )");
    Assert.assertEquals(Long.valueOf(value), Long.valueOf(17), "Expected value does not match");

    value =
        EvaluateExpression.evaluate("( ( ( 1 + 9 ) * ( 5 - 3 ) ) * ( ( 2 - 1 ) + ( 9 - 1 ) ) )");
    Assert.assertEquals(Long.valueOf(value), Long.valueOf(180), "Expected value does not match");

    value = EvaluateExpression.evaluate("( ( 10 + 200 ) * 3 )");
    Assert.assertEquals(Long.valueOf(value), Long.valueOf(630), "Expected value does not match");

    value = EvaluateExpression.evaluate("( ( 10 + 900 ) / ( 50 - 48 ) )");
    Assert.assertEquals(Long.valueOf(value), Long.valueOf(455), "Expected value does not match");
  }
}
