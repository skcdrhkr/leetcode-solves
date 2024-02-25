import utils.TreeNode;

import java.util.ArrayList;

public class LowestCommonAncestor {

    static boolean found = false;

    public static void main(String[] args) {
        Integer[] tree = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeNode.createTree(tree);
        // Case 1
        System.out.println(LowestCommonAncestor.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);

        // Case 2
        System.out.println(LowestCommonAncestor.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4)).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pl = new ArrayList<>();
        ArrayList<TreeNode> ql = new ArrayList<>();
        found = false;
        findNode(root, p, pl);
        found = false;
        findNode(root, q, ql);
        for (int i = pl.size() - 1; i >= 0; i--) {
            for (int j = ql.size() - 1; j >= 0; j--) {
                if (pl.get(i).val == ql.get(j).val)
                    return pl.get(i);
            }
        }
        return null;
    }

    private static boolean findNode(TreeNode root, TreeNode tar, ArrayList<TreeNode> ls) {
        if (root == null) {
            return false;
        }
        ls.add(root);
        if (root.val == tar.val || findNode(root.left, tar, ls) || findNode(root.right, tar, ls)) {
            return true;
        }
        ls.remove(ls.size() - 1);
        return false;
    }
}
