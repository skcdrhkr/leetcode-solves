package twopointers;

public class LowestCommonAncestorIII {

    public static void main(String[] args) {
        // Case 1
    }

    public EduTreeNode LowestCommonAncestor(EduTreeNode p, EduTreeNode q) {

        EduTreeNode po = p, qo = q;
        while (p != q) {
            p = p.parent;
            q = q.parent;
            if (p == null) p = qo;
            if (q == null) q = po;
        }
        return q;
    }
}

// Definiton of a binary tree node class
class EduTreeNode {
    int data;
    EduTreeNode left;
    EduTreeNode right;
    EduTreeNode parent;

    EduTreeNode(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
