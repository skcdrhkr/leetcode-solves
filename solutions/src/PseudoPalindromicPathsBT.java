/**
 * Problem URL: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/description
 * Level: Medium
 */

import utils.TreeNode;

public class PseudoPalindromicPathsBT {

    public static void main(String[] args) {
        // Case 1
        Integer[] case1 = new Integer[]{2, 3, 1, 3, 1, null, 1};
        TreeNode root1 = TreeNode.createTree(case1);
        System.out.println(PseudoPalindromicPathsBT.pseudoPalindromicPaths(root1));

        // Case 2
        Integer[] case2 = new Integer[]{2, 1, 1, 1, 3, null, null, null, null, null, 1};
        TreeNode root2 = TreeNode.createTree(case2);
        System.out.println(PseudoPalindromicPathsBT.pseudoPalindromicPaths(root2));

        // Case 3
        Integer[] case3 = new Integer[]{9};
        TreeNode root3 = TreeNode.createTree(case3);
        System.out.println(PseudoPalindromicPathsBT.pseudoPalindromicPaths(root3));
    }

    public static int pseudoPalindromicPaths(TreeNode root) {
        if (root == null)
            return 0;
        return palindromicPaths(root, 0);
    }

    private static int palindromicPaths(TreeNode root, int check) {
        check = check ^ (1 << root.val);
        if (root.left == null && root.right == null) {

            if ((check & (check - 1)) != 0) {
                return 0;
            } else {
                return 1;
            }
        }
        int lft = 0, right = 0;
        if (root.left != null)
            lft = palindromicPaths(root.left, check);
        if (root.right != null)
            right = palindromicPaths(root.right, check);
        return lft + right;
    }
}
