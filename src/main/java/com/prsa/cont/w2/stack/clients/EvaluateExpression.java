package com.prsa.cont.w2.stack.clients;

import com.prsa.cont.w2.stack.ArrayStack;

/**
 * Dijkstra's two-stack algorithm for expression evaluation.
 */
public class EvaluateExpression {

    final static String ADDITION = "+";
    final static String SUBTRACTION = "-";
    final static String DIVISION = "/";
    final static String MULTIPLICATION = "*";

    /**
     * Assumption : the passed expression is well formed and there is a space between any number or expression.
     * @param expression
     * @return
     */
    public static long evaluate(final String expression) {
        final String[] exp = expression.split(" ");

        final ArrayStack<Long> numbers = new ArrayStack<Long>();
        final ArrayStack<String> operations = new ArrayStack<String>();

        for (int i = 0; i < exp.length; i++) {
            final String item = exp[i];

            if (item.equals("(")) {
                continue;
            } else if (item.equals(ADDITION)) {
                operations.push(item);
            } else if (item.equals(SUBTRACTION)) {
                operations.push(item);
            } else if (item.equals(MULTIPLICATION)) {
                operations.push(item);
            } else if (item.equals(DIVISION)) {
                operations.push(item);
            } else if (item.equals(")")) {
                calculateAndPushBack(numbers, operations);
            } else {
                numbers.push(Long.valueOf(item));
            }
        }

        return numbers.pop();
    }

    private static void calculateAndPushBack(ArrayStack<Long> numbers, ArrayStack<String> operations) {
        final long item1 = numbers.pop();
        final long item2 = numbers.pop();
        final String ops = operations.pop();
        if (ops.equals(ADDITION)) {
            numbers.push(item2 + item1);
        } else if (ops.equals(SUBTRACTION)) {
            numbers.push(item2 - item1);
        } else if (ops.equals(DIVISION)) {
            numbers.push(item2 / item1);
        } else if (ops.equals(MULTIPLICATION)) {
            numbers.push(item2 * item1);
        }
    }
}