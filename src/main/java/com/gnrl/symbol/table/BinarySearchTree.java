package com.gnrl.symbol.table;

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

    public Key getKey(final Node node) {
        return node.key;
    }

    public Value getValue(final Node node) {
        return node.value;
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
    public Node getMin() {
        if (this.root == null) {
            return null;
        }

        return this.getMin(this.root);
    }

    private Node getMin(final Node node) {
        if (node.leftNode == null) {
            return node;
        }

        return this.getMin(node.leftNode);
    }

    public Node getMax() {
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
    private Node getMax(final Node node) {
        if (node.rightNode == null) {
            return node;
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
     * @return all keys, null of either min or max are null
     */
    public Iterable<Key> keys() {
        if (this.getMin() == null || this.getMax() == null) {
            return null;
        }
        return this.keys(this.getMin().key, this.getMax().key);
    }

    /**
     * get keys between the min and max
     * @param min
     * @param max
     * @return list of keys
     */
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

    /**
     * Delete the min key from the Tree. It would be the left leaf node, which may have a right child.
     */
    public void deleteMin() {
        if (this.root == null) {
            return;
        }
        this.root = this.deleteMin(this.root);
    }

    // Returns the node
    private Node deleteMin(final Node node) {
        // min as always the left most node.
        if (node.leftNode == null) {
            // if the left node has a right child, that should replace the deleted node
            return node.rightNode;
        }

        node.leftNode = this.deleteMin(node.leftNode);
        node.count = this.getSize(node.leftNode) + this.getSize(node.rightNode) + 1;
        return node;
    }

    /**
     * Delete the max key form the Tree. It would be the right node which may have a left child.
     */
    public void deleteMax() {
        if (this.root == null) {
            return;
        }
        this.root = this.deleteMax(this.root);
    }

    private Node deleteMax(final Node node) {
        // max is always the right most child
        if (node.rightNode == null) {
            // if rightmost child has a left node, that should replece the deleted node !!!
            return node.leftNode;
        }

        node.rightNode = this.deleteMax(node.rightNode);
        node.count = this.getSize(node.leftNode) + this.getSize(node.rightNode) + 1;
        return node;
    }

    /**
     * Remove {@Key} from the tree.
     * @param key
     */
    public void delete(final Key key) {
        this.root = this.delete(this.root, key);
    }

    private Node delete(Node node, final Key key) {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);

        // go further till a match is found!!
        if (compare < 0) {
            node.leftNode = this.delete(node.leftNode, key);
        }

        else if (compare > 0) {
            node.rightNode = this.delete(node.rightNode, key);
        }

        // match found
        else {
            // if either left or right child is null, we replace the deleting node with the none null node
            if (node.rightNode == null) {
                return node.leftNode;
            }

            if (node.leftNode == null) {
                return node.rightNode;
            }

            // when both left and right child are present !!
            // we keep the deleting node for the left child reference to be linked to the replaced node
            final Node temp = node;
            // find the replacement by looking for the minimum of the right sub-tree
            node = this.getMin(temp.rightNode);
            // delete the min of the right subtree and link the root of right subtree to the replaced node's right
            node.rightNode = this.deleteMin(temp.rightNode);
            // link deleted node's left subtree with replaced node's left
            node.leftNode = temp.leftNode;
        }

        // update the count of each node when the stack unwinds
        node.count = this.getSize(node.leftNode) + this.getSize(node.rightNode) + 1;
        return node;
    }
}
