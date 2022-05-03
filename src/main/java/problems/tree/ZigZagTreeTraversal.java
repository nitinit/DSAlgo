package problems.tree;

import java.util.Stack;

public class ZigZagTreeTraversal {

    // driver program to test the above function
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.rootNode = new Node1(1);
        tree.rootNode.leftChild = new Node1(2);
        tree.rootNode.rightChild = new Node1(3);
        tree.rootNode.leftChild.leftChild = new Node1(7);
        tree.rootNode.leftChild.rightChild = new Node1(6);
        tree.rootNode.rightChild.leftChild = new Node1(5);
        tree.rootNode.rightChild.rightChild = new Node1(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZagTraversal();
    }
}


class Node1
{
    int data;
    public Node1 leftChild;
    public Node1 rightChild;
    public Node1(int data)
    {
        this.data = data;
    }
}

class BinaryTree {
    public Node1 rootNode;
    void printZigZagTraversal() {
        if(rootNode == null) {
            return;
        }
        Stack<Node1> currentElement = new Stack();
        Stack<Node1> nextElement = new Stack();
        boolean leftToRight = true;

        currentElement.push(rootNode);

        while(!currentElement.isEmpty()) {
            Node1 node = currentElement.pop();
            System.out.println(node.data);
            if (leftToRight) {
                if (node.leftChild != null) {
                    nextElement.push(node.leftChild);
                }
                if (node.rightChild != null) {
                    nextElement.push(node.rightChild);
                }
            } else {
                if (node.rightChild != null) {
                    nextElement.push(node.rightChild);
                }
                if (node.leftChild != null) {
                    nextElement.push(node.leftChild);
                }
            }

            if (currentElement.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node1> tmp = currentElement;
                currentElement = nextElement;
                nextElement = tmp;
            }
        }
    }
}
