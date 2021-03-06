package com.prsa.cont.w2.queue;

import org.testng.Assert;
import org.testng.annotations.Test;

/** Tests for {@link LinkedListQueue}. */
public class LinkedListQueueTest {
  @Test
  public void testEnqueu() throws Exception {
    final LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
    final int size = 100;
    for (int i = 0; i < size; i++) {
      queue.enque(i);
    }

    Assert.assertEquals(size, queue.getSize(), "Size does not match expected");
  }

  @Test
  public void testDeque() throws Exception {
    final LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
    final int size = 100;

    for (int i = 0; i < size; i++) {
      queue.enque(i);
    }

    Assert.assertEquals(size, queue.getSize(), "Size does not match expected");

    for (int i = 0; i < size; i++) {
      Assert.assertEquals(Integer.valueOf(i), queue.deque(), "Dequed item does no match expected");
    }
  }

  @Test
  public void testGetSize() throws Exception {
    final LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
    final int size = 100;

    for (int i = 0; i < size; i++) {
      queue.enque(i);
    }

    Assert.assertEquals(size, queue.getSize(), "Size does not match expected");

    for (int i = 0; i < size; i++) {
      queue.deque();
    }

    Assert.assertEquals(0, queue.getSize(), "Size does not match expected");
  }

  @Test
  public void testIsEmpty() throws Exception {
    final LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
    final int size = 100;

    Assert.assertTrue(queue.isEmpty(), "Queue has to be empty now");

    for (int i = 0; i < size; i++) {
      queue.enque(i);
    }

    Assert.assertFalse(queue.isEmpty(), "Queue should not be empty !!!");

    for (int i = 0; i < size; i++) {
      queue.deque();
    }

    Assert.assertEquals(0, queue.getSize(), "Size does not match expected");
  }

  @Test
  public void testLinkedListQueueIterator() {
    final LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();

    final int size = 100;

    for (int i = 0; i < size; i++) {
      queue.enque(i);
    }

    Assert.assertEquals(size, queue.getSize(), "Size does not match expected");

    int count = 0;
    for (int i : queue) {
      Assert.assertEquals(count, i, "Iteration does not give expected result !!!");
      count++;
    }

    Assert.assertEquals(count, size, "for each implementation is not correct !!");
  }
}
