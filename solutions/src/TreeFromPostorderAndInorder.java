import utils.TreeNode;

import java.util.HashMap;

/**
 * Problem URL: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * Level: Medium
 */

public class TreeFromPostorderAndInorder {
    static int pind = 0;

    public static void main(String[] args) {

        // Case 0
        System.out.println(TreeFromPostorderAndInorder.buildTree(new int[]{9, 5, 10, 2, 6, 1, 4, 7, 3}, new int[]{9, 10, 5, 6, 2, 7, 4, 3, 1}));

        // Case1
        System.out.println(TreeFromPostorderAndInorder.buildTree(new int[]{3, 2, 1}, new int[]{3, 2, 1}));

        // Case 2
        System.out.println(TreeFromPostorderAndInorder.buildTree(new int[]{1, 2}, new int[]{2, 1}));

        // Case 3
        System.out.println(TreeFromPostorderAndInorder.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        pind = postorder.length - 1;
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }
        return buildTree(postorder, 0, inorder.length - 1, mp);
    }

    private static TreeNode buildTree(int[] postorder, int i, int n, HashMap<Integer, Integer> mp) {
        if (i > n) return null;

        TreeNode root = new TreeNode(postorder[pind--]);
        int ind = mp.get(root.val);
        root.right = buildTree(postorder, ind + 1, n, mp);
        root.left = buildTree(postorder, i, ind - 1, mp);
        return root;
    }
}
