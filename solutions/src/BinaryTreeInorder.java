/**
 * Problem URL: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * Level: Easy
 */

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorder {

    public static void main(String[] args) {
        // Case 1
        Integer[] arr1 = new Integer[]{1, null, 2, 3};
        TreeNode root1 = TreeNode.createTree(arr1);
        System.out.println(BinaryTreeInorder.inorderTraversal(root1));

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode cur = root;
        Stack<TreeNode> st = new Stack<>();
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
