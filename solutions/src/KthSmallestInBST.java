import utils.TreeNode;

/**
 * Problem URL: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 * Level: Medium
 */

public class KthSmallestInBST {

    static int count;
    static int res = 0;

    public static void main(String[] args) {
        // Case 1
        Integer[] case1 = new Integer[]{3, 1, 4, null, 2};
        TreeNode root1 = TreeNode.createTree(case1);
        System.out.println(KthSmallestInBST.kthSmallest(root1, 1));

        // Case 2
        Integer[] case2 = new Integer[]{5, 3, 6, 2, 4, null, null, 1};
        TreeNode root2 = TreeNode.createTree(case2);
        System.out.println(KthSmallestInBST.kthSmallest(root2, 3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return res;
    }

    private static void inorder(TreeNode root) {
        if (root.left != null)
            inorder(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        if (root.right != null)
            inorder(root.right);
    }
}
