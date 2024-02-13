import utils.TreeNode;

/**
 * Problem URL: https://leetcode.com/problems/binary-tree-maximum-path-sum/description
 * Level: Hard
 */

public class BinaryTreeMaxPathSum {

    static Integer result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // Case 1
        Integer[] arr1 = new Integer[]{1, 2, 3};
        TreeNode root1 = TreeNode.createTree(arr1);
        System.out.println(BinaryTreeMaxPathSum.maxPathSum(root1));

        // Case 2
        Integer[] arr2 = new Integer[]{-10, 9, 20, null, null, 15, 7};
        TreeNode root2 = TreeNode.createTree(arr2);
        System.out.println(BinaryTreeMaxPathSum.maxPathSum(root2));
    }

    public static int maxPathSum(TreeNode root) {
        int mx = -1;
        result = Integer.MIN_VALUE;
        maxPathSum(root, mx);
        return result;
    }

    private static int maxPathSum(TreeNode root, int mx) {
        if (root == null)
            return 0;
        int lft = maxPathSum(root.left, mx);
        int rt = maxPathSum(root.right, mx);
        result = Math.max(result, Math.max(root.val + lft, Math.max(root.val + rt, Math.max(root.val, lft + rt + root.val))));
        return Math.max(lft + root.val, Math.max(rt + root.val, root.val));
    }
}
