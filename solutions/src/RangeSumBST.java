/**
 * Problem URL: https://leetcode.com/problems/range-sum-of-bst/description
 * Level: Easy
 */

import utils.TreeNode;

public class RangeSumBST {

    public static void main(String[] args) {
        // Case 1
        Integer[] case1 = new Integer[]{10, 5, 15, 3, 7, null, 18};
        TreeNode root1 = TreeNode.createTree(case1);
        System.out.println(RangeSumBST.rangeSumBST(root1, 7, 15));

        // Case 2
        Integer[] case2 = new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6};
        TreeNode root2 = TreeNode.createTree(case2);
        System.out.println(RangeSumBST.rangeSumBST(root2, 6, 10));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val >= low) {
            return rangeSumBST(root.left, low, high);
        } else {
            return rangeSumBST(root.right, low, high);
        }
    }
}
