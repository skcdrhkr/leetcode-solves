package utils;

public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public static Node createTree(Integer[] list) {
        int n = list.length;
        if (n == 0)
            return null;
        Node[] tree = new Node[n];
        for (int i = 0; i < n; i++) {
            if (list[i] == null)
                continue;
            if (tree[i] == null) {
                tree[i] = new Node(list[i]);
            }
            if ((2 * i + 1) < n && list[2 * i + 1] != null) {
                tree[2 * i + 1] = new Node(list[2 * i + 1]);
                tree[i].left = tree[2 * i + 1];
            }
            if ((2 * i + 2) < n && list[2 * i + 2] != null) {
                tree[2 * i + 2] = new Node(list[2 * i + 2]);
                tree[i].right = tree[2 * i + 2];
            }
        }
        return tree[0];
    }
}
