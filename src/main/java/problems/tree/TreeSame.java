package problems.tree;

public class TreeSame {

    boolean isSame(Node p, Node q) {
        if(p == null && q == null) {
            return true;
        } else if ((p == null && q !=null) || (p != null && q ==null)){
            return false;
        }

        if(p.data == q.data) {
            if(isSame(p.left, q.left) &&
                    isSame(p.right, q.right)) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    public boolean isSameTree(Node p, Node q) {

        if (p == null || q == null){
            return p == q? true: false;
        }

        if(p.data != q.data){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
