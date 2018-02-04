package com.gnrl.symbol.table;

import com.prsa.cont.w2.queue.LinkedListQueue;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node leftNode = null;
        private Node rightNode = null;
        private int count;

        public Node(final Key key, final Value value, final int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }

    public Value get(final Key key) {
        return this.get(this.root, key);

    }

    private Value get(final Node node, final Key key) {
        if (node == null) {
            return null;
        }

        final int compare = key.compareTo(node.key);

        if (compare > 0) {
            return this.get(node.rightNode, key);

        } else if (compare < 0) {
            return this.get(node.leftNode, key);

        } else {
            return node.value;
        }
    }

    public void put(final Key key, final Value value) {
        this.root = this.put(this.root, key, value);
    }

    private Node put(final Node node, final Key key, final Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }

        final int compare = key.compareTo(node.key);

        if (compare > 0) {
            node.rightNode = this.put(node.rightNode, key, value);

        } else if (compare < 0) {
            node.leftNode = this.put(node.leftNode, key, value);

        } else {
            // we update the value, if key already exists
            node.value = value;
        }

        node.count = this.getSize(node.leftNode) + this.getSize(node.rightNode) + 1;
        return node;
    }

    /**
     * Get minimum value from the Tree.
     * Given the principle, go left till the leftNode is null
     * @return minimum value as {@link Value}
     */
    public Key getMin() {
        if (this.root == null) {
            return null;
        }

        return this.getMin(this.root);
    }

    private Key getMin(final Node node) {
        if (node.leftNode == null) {
            return node.key;
        }

        return this.getMin(node.leftNode);
    }

    public Key getMax() {
        if (this.root == null) {
            return null;
        }

        return this.getMax(this.root);
    }

    /**
     * Get the max value
     * @param node
     * @return max value as {@link Value}
     */
    private Key getMax(final Node node) {
        if (node.rightNode == null) {
            return node.key;
        }

        return this.getMax(node.rightNode);
    }

    /**
     * returns the total number of available nodes
     * @return
     */
    public int getSize() {
        return this.getSize(this.root);
    }

    private int getSize(final Node node) {
        if (node == null) {
            return 0;
        }
        return node.count;
    }

    /**
     * Get all keys as {@link Iterable}
     * @return all keys
     */
    public Iterable<Key> keys() {
        return this.keys(this.getMin(), this.getMax());
    }

    public Iterable<Key> keys(final Key min, final Key max) {
        final List<Key> queue = new LinkedList<>();
        this.keys(this.root, min, max, queue);
        return queue;
    }

    /**
     * find all keys between min and max
     * @param node
     * @param min
     * @param max
     * @param result
     * @return all keys in range
     */
    private void keys(final Node node, final Key min, final Key max, final List<Key> result) {
        if (node == null) {
            return;
        }

        final int compMax = max.compareTo(node.key);
        final int compMin = min.compareTo(node.key);

        // when min key is smaller than the current key, we may find more keys in range, so go left
        if (compMin < 0) {
            this.keys(node.leftNode, min, max, result);
        }

        // when the current key is in the range, add it to result
        if (compMin <= 0 && compMax >= 0) {
            result.add(node.key);
        }

        // when max key is bigger than current key, go right, to find more keys in range
        if (compMax > 0) {
            this.keys(node.rightNode, min, max, result);
        }
    }
}
