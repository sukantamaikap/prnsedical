package com.prsa.cont.w2.stack;

/** Stack implementation using LinkedList. */
public class LinkedListStack<T> {

  private int size = 0;
  private Node first = null;

  private class Node {
    T data;
    Node next;

    Node(final T t, final Node next) {
      this.data = t;
      this.next = next;
    }
  }

  public void push(final T t) {
    Node node;
    if (this.first == null) {
      node = new Node(t, null);
    } else {
      node = new Node(t, first);
    }
    this.first = node;
    this.size++;
  }

  public T pop() {
    if (this.first == null) {
      return null;
    } else {
      final T t = this.first.data;
      first = first.next;
      this.size--;
      return t;
    }
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.first == null;
  }
}
