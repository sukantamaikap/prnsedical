package com.prsa.cont.w2.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Tests for {@link LinkedListStack}.
 */
public class LinkedListStackTest {
    @Test
    public void testPush() throws Exception {
        final int size = 100;
        final LinkedListStack<Integer> items = new LinkedListStack<Integer>();
        for (int i = 0; i < size ; i++) {
            items.push(i);
        }
        Assert.assertEquals(size, items.size(), "Size does not match");
    }

    @Test
    public void testPop() throws Exception {
        final LinkedListStack<Integer> items = new LinkedListStack<Integer>();
        final int size = 100;
        for (int i = 1; i < size; i++) {
            items.push(i);
        }

        for (int i = (size -1) ; i > 0 ; i--) {
            Assert.assertEquals(Integer.valueOf(i), items.pop(), "Item does not match");
        }
    }

    @Test
    public void testSize() throws Exception {
        final LinkedListStack<Integer> items = new LinkedListStack<Integer>();
        final int size = 100;
        for (int i = 0; i < size; i++) {
            items.push(i);
        }

        Assert.assertEquals(size, items.size(), "Size does not match");

        for (int i = size; i > 0 ; i--) {
            items.pop();
        }

        Assert.assertEquals(0, items.size(), "Size does not match");
    }

}