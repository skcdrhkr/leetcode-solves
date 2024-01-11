import utils.TreeNode;

/**
 * Problem URL: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description
 * Level: Medium
 */

public class MaxDiffNodeAndAncestor {

    public static void main(String[] args) {
        // Case 1
        Integer[] case1 = new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13};
        TreeNode root1 = TreeNode.createTree(case1);
        System.out.println(MaxDiffNodeAndAncestor.maxAncestorDiff(root1));

        // Case 2
        Integer[] case2 = new Integer[]{1, null, 2, null, 0, 3};
        TreeNode root2 = TreeNode.createTree(case2);
        System.out.println(MaxDiffNodeAndAncestor.maxAncestorDiff(root2));
    }

    public static int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        return maxAncestorDiff(root, root.val, root.val);
    }

    private static int maxAncestorDiff(TreeNode root, int max, int min) {
        int res = Math.max(Math.abs(root.val - max), Math.abs(root.val - min));
        int left = 0, right = 0;
        if (root.left != null) {
            left = maxAncestorDiff(root.left, Math.max(root.val, max), Math.min(root.val, min));
        }
        if (root.right != null) {
            right = maxAncestorDiff(root.right, Math.max(root.val, max), Math.min(root.val, min));
        }
        return Math.max(res, Math.max(left, right));
    }
}
