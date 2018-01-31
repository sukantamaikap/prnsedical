package com.gnrl.symbol.table;


import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertTrue(testSearchTree.getMin().equals("Three"), "Minimum key not found for tree with one node!!");
        testSearchTree.put(9, "Nine");
        testSearchTree.put(1, "One");
        testSearchTree.put(-20, "Minus Twenty");
        testSearchTree.put(102, "One Hundred and Two");

        Assert.assertTrue(testSearchTree.getMin().equals("Minus Twenty"), "Minimum key not found!!");

        testSearchTree.put(-200, "Minus Two hundred");
        Assert.assertTrue(testSearchTree.getMin().equals("Minus Two hundred"), "Minimum key not found!!");

    }

    @Test
    public void testGetMax() throws Exception {
        final BinarySearchTree<Integer, String> testSearchTree = new BinarySearchTree<>();

        Assert.assertTrue(testSearchTree.getMax() == null, "Tree is empty, so no maximum value should be found");

        testSearchTree.put(3, "Three");
        Assert.assertTrue(testSearchTree.getMax().equals("Three"), "Maximum key not found for tree with one node!!");
        testSearchTree.put(9, "Nine");
        testSearchTree.put(1, "One");
        testSearchTree.put(-20, "Minus Twenty");
        testSearchTree.put(102, "One Hundred and Two");

        Assert.assertTrue(testSearchTree.getMax().equals("One Hundred and Two"), "Minimum key not found!!");

        testSearchTree.put(200, "Two hundred");
        Assert.assertTrue(testSearchTree.getMax().equals("Two hundred"), "Minimum key not found!!");
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
    }
}