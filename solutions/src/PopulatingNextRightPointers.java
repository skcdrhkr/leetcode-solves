/**
 * Problem URL: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 * Level: Medium
 */

import utils.Node;

import java.util.LinkedList;

public class PopulatingNextRightPointers {

    public static void main(String[] args) {
        // Case 1
        Integer[] case1 = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Node root1 = Node.createTree(case1);
        System.out.println(PopulatingNextRightPointers.connect(root1));

        // Case 2
        Integer[] case2 = new Integer[]{};
        Node root2 = Node.createTree(case2);
        System.out.println(PopulatingNextRightPointers.connect(root2));
    }

    public static Node connect(Node root) {
        if (root == null)
            return null;
        dfs(root, null);
        return root;
    }

    private static void dfs(Node root, Node nxt) {
        if (root == null)
            return;
        root.next = nxt;
        dfs(root.left, root.right);
        dfs(root.right, root.next == null ? null : root.next.left);
    }

    public static Node connectLevelOrder(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            Node cur;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (prev != null) {
                    prev.next = cur;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                prev = cur;
            }
        }
        return root;
    }

}