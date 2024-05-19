import utils.TreeNode;

public class EvenGrandChildSum {

    static int result = 0;

    public static void main(String[] args) {
        // Case 1
        System.out.println(EvenGrandChildSum.sumEvenGrandparent(TreeNode.createTree(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5})));

        // Case 2
        System.out.println(EvenGrandChildSum.sumEvenGrandparent(TreeNode.createTree(new Integer[]{1})));
    }

    public static int sumEvenGrandparent(TreeNode root) {
        result = 0;
        getGrandChildSum(root, null);
        return result;
    }

    private static void getGrandChildSum(TreeNode root, TreeNode parent) {
        if (root == null) return;
        if (parent != null && parent.val % 2 == 0) {
            if (root.left != null) result += root.left.val;
            if (root.right != null) result += root.right.val;
        }
        getGrandChildSum(root.left, root);
        getGrandChildSum(root.right, root);
    }
}
