package problems.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelOrderTraversal {

    static List<List<Integer>> n = new ArrayList<>();

    public static List<List<Integer>> levelOrder(Node root) {

        levelOrderPrint(root, 0);
        return n;
    }

    public static void treeOrderPrint(Node root, int level) {
        // start the current level
        if (n.size() == level)
            n.add(new ArrayList<Integer>());

        // fulfil the current level
        n.get(level).add(root.data);

        // process child nodes for the next level
        if (root.left != null)
            treeOrderPrint(root.left, level + 1);
        if (root.right != null)
            treeOrderPrint(root.right, level + 1);
    }

    public static void  levelOrderPrint(Node root, int level) {

        if(root == null) {
            return;
        }
        if(n.isEmpty()) {
            n.add(new ArrayList(Arrays.asList(root.data)));
        } else if(n.size() -1 >= level){
            n.get(level).add(root.data);
        } else {
            n.add(new ArrayList(Arrays.asList(root.data)));
        }
        levelOrderPrint(root.left, level +1);
        levelOrderPrint(root.right, level + 1);
    }

    public static void main(String args[]) {
        Node node1 = new Node( 1 );
        Node node2 = new Node( 2 );
        Node node3 = new Node( 3 );
        Node node4 = new Node( 4 );
        Node node5 = new Node( 5 );

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(levelOrder(node1));

    }
}
