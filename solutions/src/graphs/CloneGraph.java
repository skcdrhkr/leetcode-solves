package graphs;

import java.util.*;

public class CloneGraph {

    private static HashMap<Node, Node> visited = new HashMap<>();

    public static void main(String[] args) {
        // Case 1
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors.add(two);
        one.neighbors.add(four);
        two.neighbors.add(one);
        two.neighbors.add(three);
        three.neighbors.add(two);
        three.neighbors.add(four);
        four.neighbors.add(one);
        four.neighbors.add(three);
        System.out.println(CloneGraph.cloneGraph(one));
    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);
        for (Node neighbors : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbors));
        }
        return clone;
    }

    public static Node cloneGraphIterative(Node node) {
        if (node == null) return null;
        Map<Integer, Node> mapping = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            mapping.put(top.val, new Node(top.val));
            List<Node> neighbors = top.neighbors;
            for (Node temp : neighbors) {
                if (!mapping.containsKey(temp.val)) {
                    queue.add(temp);
                }
            }
        }
        queue.add(node);
        boolean[] vis = new boolean[mapping.size() + 1];
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            Node clonedNode = mapping.get(top.val);
            if (vis[top.val]) continue;
            vis[top.val] = true;
            List<Node> neighbors = top.neighbors;
            List<Node> clonedNeigbors = clonedNode.neighbors;
            for (Node temp : neighbors) {
                if (!vis[temp.val]) queue.add(temp);
                clonedNeigbors.add(mapping.get(temp.val));
            }
        }
        return mapping.get(node.val);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
