import utils.TreeNode;

public class AddOneRowToTree {

    public static void main(String[] args) {
        // Case 1
        TreeNode root1 = TreeNode.createTree(new Integer[]{4, 2, 6, 3, 1, 5, null});
        System.out.println(AddOneRowToTree.addOneRow(root1, 1, 2));

        TreeNode root2 = TreeNode.createTree(new Integer[]{4, 2, null, 3, 1, null, null});
        System.out.println(AddOneRowToTree.addOneRow(root2, 1, 3));
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        addOneRow(root, val, depth, 1);
        return root;
    }

    private static void addOneRow(TreeNode root, int val, int depth, int cur) {
        if (depth - 1 == cur) {
            TreeNode newLeft = new TreeNode(val);
            newLeft.left = root.left;
            root.left = newLeft;
            TreeNode newRight = new TreeNode(val);
            newRight.right = root.right;
            root.right = newRight;
            return;
        }
        if (root.left != null)
            addOneRow(root.left, val, depth, cur + 1);
        if (root.right != null)
            addOneRow(root.right, val, depth, cur + 1);
    }
}
