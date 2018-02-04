package com.gnrl.symbol.table;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;

public class BinarySearchTreeTest {

    @Test
    public void testGet() throws Exception {
        final BinarySearchTree<Integer, String> testSearchTree = new BinarySearchTree<>();
        testSearchTree.put(3, "Three");
        testSearchTree.put(9, "Nine");
        testSearchTree.put(1, "One");
        testSearchTree.put(-20, "Minus Twenty");
        testSearchTree.put(102, "One Hundred and Two");


        Assert.assertTrue(testSearchTree.get(1).equals("One"), "root key not found");
        Assert.assertTrue(testSearchTree.get(3).equals("Three"), "Key not found !!");
        Assert.assertTrue(testSearchTree.get(11) == null, "Key should not be found !!!!");
        Assert.assertTrue(testSearchTree.get(10203948) == null, "This key should not be found!!!");

        testSearchTree.put(1, "Onne");
        Assert.assertTrue(testSearchTree.get(-20).equals("Minus Twenty"), "Minimum key not found");
        Assert.assertTrue(testSearchTree.get(102).equals("One Hundred and Two"), "Maximum key not found");
    }


    @Test
    public void testGetMin() throws Exception {
        final BinarySearchTree<Integer, String> testSearchTree = new BinarySearchTree<>();

        Assert.assertTrue(testSearchTree.getMin() == null, "Tree is empty, so no minimum value should be found");

        testSearchTree.put(3, "Three");
        Assert.assertEquals(testSearchTree.getMin(), new Integer(3), "Minimum key not found for tree with one node!!");
        testSearchTree.put(9, "Nine");
        testSearchTree.put(1, "One");
        testSearchTree.put(-20, "Minus Twenty");
        testSearchTree.put(102, "One Hundred and Two");

        Assert.assertEquals(testSearchTree.getMin(), new Integer(-20), "Minimum key not found!!");

        testSearchTree.put(-200, "Minus Two hundred");
        Assert.assertEquals(testSearchTree.getMin(), new Integer(-200), "Minimum key not found!!");

    }

    @Test
    public void testGetMax() throws Exception {
        final BinarySearchTree<Integer, String> testSearchTree = new BinarySearchTree<>();

        Assert.assertTrue(testSearchTree.getMax() == null, "Tree is empty, so no maximum value should be found");

        testSearchTree.put(3, "Three");
        Assert.assertEquals(testSearchTree.getMax(), new Integer(3), "Maximum key not found for tree with one node!!");
        testSearchTree.put(9, "Nine");
        testSearchTree.put(1, "One");
        testSearchTree.put(-20, "Minus Twenty");
        testSearchTree.put(102, "One Hundred and Two");

        Assert.assertEquals(testSearchTree.getMax(), new Integer(102), "Minimum key not found!!");

        testSearchTree.put(200, "Two hundred");
        Assert.assertEquals(testSearchTree.getMax(), new Integer(200), "Minimum key not found!!");
    }

    @Test
    public void testGetSize() throws Exception {
        final BinarySearchTree<Integer, String> testSearchTree = new BinarySearchTree<>();
        Assert.assertEquals(testSearchTree.getSize(), 0, "Size should be zero for a tree with no nodes !!");

        testSearchTree.put(1, "1");
        Assert.assertEquals(testSearchTree.getSize(), 1, "Size should be one for a tree with one nodes !!");

        testSearchTree.put(2, "2");
        Assert.assertEquals(testSearchTree.getSize(), 2, "Size should be two for a tree with two nodes !!");

        testSearchTree.put(-100, "-100");
        testSearchTree.put(-10, "-10");
        testSearchTree.put(3, "3");
        testSearchTree.put(5, "5");
        Assert.assertEquals(testSearchTree.getSize(), 6, "Size should be six for a tree with six nodes !!");

        testSearchTree.put(5, "5~");
        Assert.assertEquals(testSearchTree.getSize(), 6, "Size should be six for a tree with six nodes !!");
    }

    @Test
    public void testKeys() throws Exception {
        final BinarySearchTree<Integer, String> testSearchTree = new BinarySearchTree<>();
        Assert.assertEquals(this.getIteratorSize(testSearchTree.keys()), 0, "There should be no items as no item has been inserted !!!");

        testSearchTree.put(8, "8");
        testSearchTree.put(2, "2");
        testSearchTree.put(12, "12");
        testSearchTree.put(10, "10");
        testSearchTree.put(-2, "-2");
        testSearchTree.put(-10, "-10");
        testSearchTree.put(5, "5");
        testSearchTree.put(9, "9");
        testSearchTree.put(102, "102");
        testSearchTree.put(11, "11");

        Assert.assertEquals(this.getIteratorSize(testSearchTree.keys()), 10, "Key size does not match !!");

    }

    @Test
    public void testKeysWithRange() throws Exception {
        final BinarySearchTree<Integer, String> testSearchTree = new BinarySearchTree<>();
        Assert.assertEquals(this.getIteratorSize(testSearchTree.keys()), 0, "There should be no items as no item has been inserted !!!");

        testSearchTree.put(8, "8");
        testSearchTree.put(2, "2");
        testSearchTree.put(12, "12");
        testSearchTree.put(10, "10");
        testSearchTree.put(-2, "-2");
        testSearchTree.put(-10, "-10");
        testSearchTree.put(5, "5");
        testSearchTree.put(9, "9");
        testSearchTree.put(102, "102");
        testSearchTree.put(11, "11");

        Assert.assertEquals(this.getIteratorSize(testSearchTree.keys(8, 10)), 3, "Key size does not match !!");
        Assert.assertEquals(this.getIteratorSize(testSearchTree.keys(199, 999)), 0, "Key size does not match !!");
        Assert.assertEquals(this.getIteratorSize(testSearchTree.keys(-199, -32)), 0, "Key size does not match !!");
    }

    private int getIteratorSize(final Iterable iterable) {
        int count = 0;
        final Iterator itr = iterable.iterator();
        while (itr.hasNext()) {
            count++;
            itr.next();
        }
        return count;
    }
}