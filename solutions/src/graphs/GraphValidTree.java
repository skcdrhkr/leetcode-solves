package graphs;

import java.util.*;

public class GraphValidTree {

    public static void main(String[] args) {

        // Case 0
        System.out.println(GraphValidTree.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {3, 4}}));

        // Case 1
        System.out.println(GraphValidTree.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}}));

        // Case 2
        System.out.println(GraphValidTree.validTree(6, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 4}, {0, 5}}));
    }

    public static boolean validTree(int n, int[][] edges) {
        // Replace this placeholder return statement with your code
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }
        boolean[] vis = new boolean[n];
        if (graph.isEmpty()) return n == 1;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                int top = queue.poll();
                if (vis[top]) return false;
                vis[top] = true;
                for (int x : graph.get(top)) {
                    if (!vis[x])
                        queue.add(x);
                }
            }
        }
        for (boolean temp : vis) {
            if (!temp) return false;
        }
        return true;
    }

}
