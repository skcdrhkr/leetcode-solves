package utils;

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
        if (n == 0)
            return null;
        TreeNode[] tree = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            if (list[i] == null)
                continue;
            if (tree[i] == null) {
                tree[i] = new TreeNode(list[i]);
            }
            if ((2 * i + 1) < n && list[2 * i + 1] != null) {
                tree[2 * i + 1] = new TreeNode(list[2 * i + 1]);
                tree[i].left = tree[2 * i + 1];
            }
            if ((2 * i + 2) < n && list[2 * i + 2] != null) {
                tree[2 * i + 2] = new TreeNode(list[2 * i + 2]);
                tree[i].right = tree[2 * i + 2];
            }
        }
        return tree[0];
    }
}
