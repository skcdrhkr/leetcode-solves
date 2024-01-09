/**
 * Problem URL: https://leetcode.com/problems/leaf-similar-trees/description
 * Level: Easy
 */

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    public static void main(String[] args) {
        // Case 1
        Integer[] case11 = new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4};
        TreeNode root1 = TreeNode.createTree(case11);
        Integer[] case12 = new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8};
        TreeNode root2 = TreeNode.createTree(case12);
        System.out.println(LeafSimilarTrees.leafSimilar(root1, root2));

        // Case 1
        Integer[] case21 = new Integer[]{1, 2, 3};
        TreeNode root3 = TreeNode.createTree(case21);
        Integer[] case22 = new Integer[]{1, 3, 2};
        TreeNode root4 = TreeNode.createTree(case22);
        System.out.println(LeafSimilarTrees.leafSimilar(root3, root4));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        } else if (root2 == null) {
            return false;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        levelOrderLeafs(root1, list1);
        levelOrderLeafs(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i))
                return false;
        }
        return true;
    }

    static void levelOrderLeafs(TreeNode root, List<Integer> leafs) {
        if (root.left != null) {
            levelOrderLeafs(root.left, leafs);
        }
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
        }
        if (root.right != null) {
            levelOrderLeafs(root.right, leafs);
        }
    }
}
