package problems.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxPathSumInTree {
    public static int findMaxPathSum(Node tree, Result result) {
        if (tree == null) {
            return 0;
        }
        int leftSum = findMaxPathSum(tree.left, result);
        int rightSum = findMaxPathSum(tree.right, result);

        if (leftSum + rightSum + tree.data > result.data) {
            result.data = leftSum + rightSum + tree.data;
        }
        if (leftSum > rightSum) {
            return leftSum + tree.data;
        } else {
            return rightSum + tree.data;
        }
    }

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.left = node2;
        node1.right = node3;
        Result result = new Result();
        findMaxPathSum(node1, result);
        assertEquals(6, result.data);
    }

    @Test
    public void edgeTest() {
        Node node4 = new Node(-2);
        Node node5 = new Node(-1);
        node4.left = node5;
        Result result = new Result();
        findMaxPathSum(node4, result);
        assertEquals(-1, result.data);
    }

    @Test
    public void testSet2() {
        Node root = new Node(-15);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        root.right.right.right = new Node(0);
        root.right.right.right.left = new Node(4);
        root.right.right.right.right = new Node(-1);
        root.right.right.right.right.left = new Node(10);

        Result result = new Result();
        findMaxPathSum(root, result);
        assertEquals(27, result.data);
    }

    @Test
    public void testSet3() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(5);
        root.left.right = new Node(11);

        Result result = new Result();
        findMaxPathSum(root, result);

        assertEquals(18, result.data);
    }
}

class Result {
    int data = Integer.MIN_VALUE;
}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
