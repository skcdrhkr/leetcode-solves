import utils.TreeNode;

import java.util.HashMap;

/**
 * Problem URL: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * Level: Medium
 */

public class TreeFromPreorderAndInorder {
    static int pind = 0;

    public static void main(String[] args) {

        // Case 0
        System.out.println(TreeFromPreorderAndInorder.buildTree(new int[]{1, 2, 5, 9, 10, 6, 3, 4, 7}, new int[]{9, 5, 10, 2, 6, 1, 4, 7, 3}));

        // Case1
        System.out.println(TreeFromPreorderAndInorder.buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1}));

        // Case 2
        System.out.println(TreeFromPreorderAndInorder.buildTree(new int[]{1, 2}, new int[]{1, 2}));

        // Case 3
        System.out.println(TreeFromPreorderAndInorder.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        pind = 0;
        for (int i = 0; i < n; i++) {
            mp.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n - 1, mp);
    }

    private static TreeNode buildTree(int[] preorder, int i, int n, HashMap<Integer, Integer> mp) {
        if (pind >= preorder.length || i > n)
            return null;
        TreeNode node = new TreeNode(preorder[pind++]);
        int ind = mp.get(node.val);
        node.left = buildTree(preorder, i, ind - 1, mp);
        node.right = buildTree(preorder, ind + 1, n, mp);
        return node;
    }
}
