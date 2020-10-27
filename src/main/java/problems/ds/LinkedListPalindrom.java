package problems.ds;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListPalindrom {

    Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    
    @Test
    public void test1() {

        Node start = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        start.next = second;
        second.next = third;

        Node reverseNode = reverse(start);
        while (start != null) {
             System.out.println(start.val);
            start = start.next;
        }
    }
}

class Node {
    public int val;
    public Node next;

    public Node(int x) {
        this.val = x;
    }
}