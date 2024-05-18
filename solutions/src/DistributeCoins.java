import utils.TreeNode;

public class DistributeCoins {

    static int moves = 0;

    public static void main(String[] args) {
        // Case 1
        System.out.println(DistributeCoins.distributeCoins(TreeNode.createTree(new Integer[]{3, 0, 0})));

        // Case 2
        System.out.println(DistributeCoins.distributeCoins(TreeNode.createTree(new Integer[]{0, 3, 0})));
    }

    public static int distributeCoins(TreeNode root) {
        moves = 0;
        minCoinsMove(root);
        return moves;
    }

    private static int minCoinsMove(TreeNode root) {
        if (root == null) return 0;
        int left = minCoinsMove(root.left);
        int right = minCoinsMove(root.right);
        int toMove = left + right + root.val - 1;
        moves += Math.abs(toMove);
        return toMove;
    }
}
