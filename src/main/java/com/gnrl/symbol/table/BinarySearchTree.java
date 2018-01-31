package com.gnrl.symbol.table;

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

    private Node put(Node node, final Key key, final Value value) {
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

        return node;
    }

    /**
     * Get minimum value from the Tree.
     * Given the principle, go left till the leftNode is null
     * @return minimum value as {@link Value}
     */
    public Value getMin() {
        if (this.root == null) {
            return null;
        }

        return this.getMin(this.root);
    }

    private Value getMin(final Node node) {
        if (node.leftNode == null) {
            return node.value;
        }

        return this.getMin(node.leftNode);
    }

    public Value getMax() {
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
    private Value getMax(final Node node) {
        if (node.rightNode == null) {
            return node.value;
        }

        return this.getMax(node.rightNode);
    }

    public int getSize() {
        if (this.root == null) {
            return 0;
        }

        return this.root.count;
    }
}
