import utils.TreeNode;

/**
 * Problem URL: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 * Level: Medium
 */

public class SumRootToLeafNumbers {

    static int result = 0;

    public static void main(String[] args) {
        // Case 1
        Integer[] case1 = new Integer[]{1, 2, 3};
        TreeNode root1 = TreeNode.createTree(case1);
        System.out.println(SumRootToLeafNumbers.sumNumbers(root1));

        // Case 2
        Integer[] case2 = new Integer[]{4, 9, 0, 5, 1};
        TreeNode root2 = TreeNode.createTree(case2);
        System.out.println(SumRootToLeafNumbers.sumNumbers(root2));
    }

    public static int sumNumbers(TreeNode root) {
        result = 0;
        if (root == null)
            return 0;
        sumNumbers(root, 0);
        return result;
    }

    private static void sumNumbers(TreeNode root, int curSum) {
        curSum = curSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            result += curSum;
            return;
        }
        if (root.left != null)
            sumNumbers(root.left, curSum);
        if (root.right != null) {
            sumNumbers(root.right, curSum);
        }
    }
}
