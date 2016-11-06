package com.prsa.cont.w2.stack;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * ArrayStack end to end tests.
 */
public class ArrayStackTest {

    @Test
    public void testIntStack() {
        final int capacity = 10;
        final ArrayStack<Integer> integerStack = new ArrayStack<Integer>(capacity);
        for (int i = 0; i < capacity; i++) {
            integerStack.push(i);
        }
        for (int j = 0; j < capacity; j++) {
            final int expectedOutput = capacity - j - 1;
            Integer poppedItem = integerStack.pop();
            assertTrue(poppedItem == expectedOutput, "Item was not inserted properly, expected : " + expectedOutput + " but found : " + poppedItem);
        }
    }

    @Test
    public void testStackResizing() {
        final int testCapacity = 10000;
        final ArrayStack<Integer> integerStack = new ArrayStack<Integer>();
        for (int i = 0; i < testCapacity; i++) {
            integerStack.push(i);
        }

        assertTrue(integerStack.getCapacity() > testCapacity, "expected capacity does not match");

        for (int j = 0; j < testCapacity; j++) {
            final int expectedOutput = testCapacity - j - 1;
            Integer poppedItem = integerStack.pop();
            assertTrue(poppedItem == expectedOutput, "Item was not inserted properly, expected : " + expectedOutput + " but found : " + poppedItem);
        }

        assertTrue(integerStack.getCapacity() == 1, "expected capacity is 2 when all items are popped, found : " + integerStack.getCapacity());

        for (int i = 0; i < testCapacity; i++) {
            integerStack.push(i);
        }

        assertTrue(integerStack.getCapacity() > testCapacity, "expected capacity does not match");

        for (int j = 0; j < testCapacity; j++) {
            final int expectedOutput = testCapacity - j - 1;
            Integer poppedItem = integerStack.pop();
            assertTrue(poppedItem == expectedOutput, "Item was not inserted properly, expected : " + expectedOutput + " but found : " + poppedItem);
        }
    }

    @Test
    public void testStackIterator() {
        final int testCapacity = 100;
        final ArrayStack<Integer> integerStack = new ArrayStack<Integer>();
        for (int i = 0; i < testCapacity; i++) {
            integerStack.push(i);
        }

        int count = 0;
        for (int i : integerStack) {
            final int expectedOutput = testCapacity - count - 1;
            assertTrue(i == expectedOutput, "Item was not inserted properly, expected : " + expectedOutput + " but found : " + i);
            count++;
        }

        count = 0;
        for (int i : integerStack) {
            final int expectedOutput = testCapacity - count - 1;
            assertTrue(i == expectedOutput, "Item was not inserted properly, expected : " + expectedOutput + " but found : " + i);
            count++;
        }
    }
}