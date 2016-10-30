package com.prsa.cont.w2.stack;

/**
 * Dijkstra's two-stack algorithm for expression evaluation.
 */
public class EvaluateExpression {

    final static String ADDITION = "+";
    final static String SUBTRACTION = "-";
    final static String DIVISION = "/";
    final static String MULTIPLICATION = "*";

    /**
     * Assumption : the passed expression is well formed.
     * @param expression
     * @return
     */
    public static int evaluate(final String expression) {

        final Stack<Integer> numbers = new Stack<Integer>();
        final Stack<String> operations = new Stack<String>();

        for (int i = 0; i < expression.length(); i++) {
            final String item = String.valueOf(expression.charAt(i));

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
                numbers.push(Integer.valueOf(item));
            }
        }

        while (numbers.size() > 1) {
            calculateAndPushBack(numbers, operations);
        }

        return numbers.pop();
    }

    private static void calculateAndPushBack(Stack<Integer> numbers, Stack<String> operations) {
        final int item1 = numbers.pop();
        final int item2 = numbers.pop();
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