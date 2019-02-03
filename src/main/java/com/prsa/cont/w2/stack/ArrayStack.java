package com.prsa.cont.w2.stack;

import java.util.Iterator;

/** ArrayStack implementation with resizing generic array. */
public class ArrayStack<T> implements Iterable<T> {
  private T[] stack;
  private int head = 0;
  private int capacity;

  public ArrayStack() {
    this(10);
  }

  public ArrayStack(final int capacity) {
    this.capacity = capacity;
    this.stack = (T[]) new Object[this.capacity];
  }

  public void push(final T t) {
    if (this.head == capacity) {
      this.resizeUp();
    }
    this.stack[this.head++] = t;
  }

  public T pop() {
    final T popped = this.stack[--this.head];
    this.stack[this.head] = null;
    if (this.head <= this.capacity / 4) {
      this.resizeDown();
    }
    return popped;
  }

  private void resizeUp() {
    this.capacity = this.capacity * 2;
    this.resizeStack();
  }

  private void resizeDown() {
    this.capacity = this.capacity / 2;
    this.resizeStack();
  }

  private void resizeStack() {
    final T[] newStack = (T[]) new Object[this.capacity];
    for (int i = 0; i < this.head; i++) {
      newStack[i] = this.stack[i];
    }

    this.stack = newStack;
  }

  public int size() {
    return this.head;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public Iterator<T> iterator() {
    return new ReverseArrayTraversalIterator();
  }

  private class ReverseArrayTraversalIterator implements Iterator<T> {
    int i = ArrayStack.this.head;

    public boolean hasNext() {
      return this.i > 0;
    }

    public T next() {
      return ArrayStack.this.stack[--this.i];
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
