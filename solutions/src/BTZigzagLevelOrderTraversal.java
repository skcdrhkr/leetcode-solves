/**
 * Problem URL: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * Level: Medium
 */

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BTZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        Integer[] case1 = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode root1 = TreeNode.createTree(case1);
        System.out.println(BTZigzagLevelOrderTraversal.zigzagLevelOrder(root1));

        Integer[] case2 = new Integer[]{1};
        TreeNode root2 = TreeNode.createTree(case2);
        System.out.println(BTZigzagLevelOrderTraversal.zigzagLevelOrder(root2));

        Integer[] case3 = new Integer[]{};
        TreeNode root3 = TreeNode.createTree(case3);
        System.out.println(BTZigzagLevelOrderTraversal.zigzagLevelOrder(root3));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean dir = false;
        int size;
        queue.add(root);
        while (!queue.isEmpty()) {
            size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            if (dir) {
                Collections.reverse(level);
                result.add(level);
            } else {
                result.add(level);
            }
            dir = !dir;
        }
        return result;
    }
}
