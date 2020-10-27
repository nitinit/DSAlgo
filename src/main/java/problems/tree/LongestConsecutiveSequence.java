package problems.tree;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LongestConsecutiveSequence {

    public  int findLongestSequence(Node tree, Result result) {
        if (tree == null) {
            return 0;
        }

        if(tree.left == null && tree.right == null) {
            return 1;
        }

        int leftLength = findLongestSequence(tree.left, result);
        int rightLength = findLongestSequence(tree.right, result);

        if (tree.left != null && tree.left.data - tree.data == 1) {
            leftLength = leftLength + 1;
        }
        if (tree.right != null && tree.right.data - tree.data == 1) {
            rightLength = rightLength + 1;
        }
        int tempLength = 0;
        if (leftLength > rightLength) {
            tempLength = leftLength;
        } else {
            tempLength = rightLength;
        }

        if(tempLength > result.data) {
            result.data = tempLength;
        }
        return tempLength;
    }

    @Test
    public void test1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        node4.right = node5;
        Result result = new Result();
        assertEquals(3, findLongestSequence(node1, result));
    }

    @Test
    public void test2()
    {
        Node node1 = new Node( 2 );
        Node node2 = new Node( 3 );
        Node node3 = new Node( 2 );
        Node node4 = new Node( 1 );
        node1.right = node2;
        node2.left = node3;
        node3.left = node4;
        Result result = new Result();
        assertEquals( 2, findLongestSequence( node1, result ) );
    }

    @Test
    public void test3() {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(13);
        root.left.right = new Node(12);
        root.right.left = new Node(13);
        root.right.right = new Node(8);

        Result result = new Result();
        assertEquals( 3, findLongestSequence( root, result ) );
    }

}


