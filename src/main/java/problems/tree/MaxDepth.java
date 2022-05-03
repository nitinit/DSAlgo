package problems.tree;

public class MaxDepth {

    public static int maxDepth(Node root) {
        return (root == null) ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    static int max=0;
    public static int maxDepth1(Node root) {
        helper(root,1);
        return max;
    }
    public static void helper(Node r, int d){
        if(r==null)
            return;
        max = d > max ? d : max;
        helper(r.left,d+1);
        helper(r.right,d+1);
    }

    public static void main(String args[]) {
        Node node1 = new Node( 2 );
        Node node2 = new Node( 3 );
        Node node3 = new Node( 2 );
        Node node4 = new Node( 1 );
        node1.right = node2;
        node2.left = node3;
        node3.left = node4;
        System.out.println(maxDepth(node1));
        System.out.println(maxDepth1(node1));

    }
}

