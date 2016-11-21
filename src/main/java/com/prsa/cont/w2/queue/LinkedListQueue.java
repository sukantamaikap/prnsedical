package com.prsa.cont.w2.queue;

import java.util.Iterator;

/**
 * Queue implementation with linked list.
 */
public class LinkedListQueue<T> implements Iterable<T> {
    private int size = 0;
    private Node head = null;
    private Node tail = null;


    private class Node {
        T data;
        Node next;

        Node(final T t, final Node next) {
            this.data = t;
            this.next = next;
        }
    }

    public void enque(final T t) {
        final Node node = new Node(t, null);
        if (this.isEmpty()) {
            this.head = this.tail = node;
        } else {
            this.head.next = node;
            this.head = head.next;
        }
        this.size++;
    }

    public T deque() {
        if (this.isEmpty()) {
            return null;
        }

        if (this.head == this.tail) {
            this.head = null;
        }

        final Node remove = this.tail;
        this.tail = remove.next;
        remove.next = null;
        this.size--;
        return remove.data;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public Iterator<T> iterator() {
        return new LinkedListQueueIterator();
    }


    private class LinkedListQueueIterator implements Iterator<T> {
        Node scanner = LinkedListQueue.this.tail;

        public boolean hasNext() {
            return scanner != null;
        }

        public T next() {
            final T t = scanner.data;
            scanner = scanner.next;
            return t;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
