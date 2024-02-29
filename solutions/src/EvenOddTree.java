import utils.TreeNode;

/**
 * Problem URL: https://leetcode.com/problems/even-odd-tree/description/
 * Level: Medium
 */

public class EvenOddTree {

    public static void main(String[] args) {
        // Case 1
        Integer[] arr1 = new Integer[]{1, 10, 4, 3, null, 7, 9, 12, 8, null, null, 6, null, null, 2};
        System.out.println(EvenOddTree.isEvenOddTree(TreeNode.createTree(arr1)));

        // Case 2
        Integer[] arr2 = new Integer[]{5, 4, 2, 3, 3, 7};
        System.out.println(EvenOddTree.isEvenOddTree(TreeNode.createTree(arr2)));

        // Case 3
        Integer[] arr3 = new Integer[]{5, 9, 1, 3, 5, 7};
        System.out.println(EvenOddTree.isEvenOddTree(TreeNode.createTree(arr3)));
    }

    public static boolean isEvenOddTree(TreeNode root) {
        int depth = getDepth(root);
        TreeNode[] traversal = new TreeNode[depth];
        return isEvenOddTree(root, 0, traversal);
    }

    private static int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }


    private static boolean isEvenOddTree(TreeNode root, int level, TreeNode[] traversal) {
        if ((level & 1) == 0 && (root.val & 1) == 0)
            return false;
        if ((level & 1) != 0 && (root.val & 1) != 0)
            return false;
        if (traversal[level] != null) {
            TreeNode prev = traversal[level];
            if (level % 2 == 0) {
                if (root.val <= prev.val)
                    return false;
            } else {
                if (root.val >= prev.val)
                    return false;
            }
        }
        traversal[level] = root;
        boolean lft = true, rt = true;
        if (root.left != null) {
            lft = isEvenOddTree(root.left, level + 1, traversal);
        }
        if (lft && root.right != null) {
            rt = isEvenOddTree(root.right, level + 1, traversal);
        }
        return lft && rt;
    }
}
