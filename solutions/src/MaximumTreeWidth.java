import utils.TreeNode;

import java.util.LinkedList;

public class MaximumTreeWidth {

    public static void main(String[] args) {
        // Case 1
        TreeNode root1 = TreeNode.createTree(new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, null, null, null, null, 7, null});
        System.out.println(MaximumTreeWidth.widthOfBinaryTree(root1));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int max = 0, cur = 0;
        queue.add(root);
        root.val = 0;
        while (!queue.isEmpty()) {
            int siz = queue.size();
            int first = -1, last = -1;
            for (int i = 0; i < siz; i++) {
                TreeNode top = queue.pollFirst();
                if (first == -1) first = top.val;
                last = top.val;
                if (top.left != null) {
                    top.left.val = top.val * 2;
                    queue.add(top.left);
                }
                if (top.right != null) {
                    top.right.val = top.val * 2 + 1;
                    queue.add(top.right);
                }
            }
            if (max < (last - first + 1)) max = last - first + 1;
        }
        return max;
    }

}
