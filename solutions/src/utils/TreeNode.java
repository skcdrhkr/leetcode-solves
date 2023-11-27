package utils;

import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer[] list) {
        int n = list.length;
        TreeNode root = null, cur, prev;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (n == 0)
            return root;
        for (Integer integer : list) {
            cur = integer == null ? null : new TreeNode(integer);
            if (!queue.isEmpty()) {
                prev = queue.peek();
                if (prev.left == null) {
                    prev.left = cur;
                } else if (prev.right == null) {
                    prev.right = cur;
                    queue.poll();
                }
            } else {
                root = cur;
            }
            if (cur != null)
                queue.add(cur);
        }
        return root;
    }
}
