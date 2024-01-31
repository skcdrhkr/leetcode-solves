import utils.TreeNode;

/**
 * Problem URL: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * Level: Medium
 */

public class TreeFromPreorderAndInorder {
    static int ind = 0;

    public static void main(String[] args) {
        // Case1
        System.out.println(TreeFromPreorderAndInorder.buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1}));

        // Case 2
        System.out.println(TreeFromPreorderAndInorder.buildTree(new int[]{1, 2}, new int[]{1, 2}));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        ind = -1;
        return buildTree(preorder, inorder, 0, n - 1);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int lo, int hi) {
        if (lo > hi)
            return null;
        ind += 1;
        if (lo == hi) {
            return new TreeNode(preorder[ind]);
        }
        TreeNode cur = new TreeNode(preorder[ind]);
        int index = indexInInorder(inorder, cur.val, lo, hi);
        cur.left = buildTree(preorder, inorder, lo, index - 1);
        cur.right = buildTree(preorder, inorder, index + 1, hi);
        return cur;
    }

    private static int indexInInorder(int[] inorder, int num, int lo, int hi) {
        while (lo <= hi) {
            if (inorder[lo] == num)
                return lo;
            lo += 1;
        }
        return -1;
    }
}
