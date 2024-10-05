package graphs;

import java.util.*;

public class NetworkDelayTime {

    record Pair(int node, int weight) {
    }

    public static void main(String[] args) {
        // Case 1
        System.out.println(NetworkDelayTime.networkDelayTime(new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 4, 15}}, 4, 1));

        // Case 2
        System.out.println(NetworkDelayTime.networkDelayTime(new int[][]{{1, 2, 5}, {2, 3, 10}, {2, 4, 15}}, 4, 1));

        // Case 3
        System.out.println(NetworkDelayTime.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int time = edge[2];
            graph.computeIfAbsent(from, x -> new ArrayList<>()).add(new Pair(to, time));
        }
        int[] vis = new int[n + 1];
        Arrays.fill(vis, Integer.MAX_VALUE);
        sendSignalToGraph(graph, vis, k);
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (vis[i] == Integer.MAX_VALUE) return -1;
            else {
                result = Math.max(result, vis[i]);
            }
        }
        return result;
    }

    private static void sendSignalToGraph(Map<Integer, List<Pair>> graph, int[] vis, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::weight));
        pq.add(new Pair(k, 0));
        vis[k] = 0;
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int weight = current.weight;
            List<Pair> neighbors = graph.getOrDefault(current.node, new ArrayList<>());
            for (Pair next : neighbors) {
                if (vis[next.node] > (weight + next.weight)) {
                    vis[next.node] = (weight + next.weight);
                    pq.add(new Pair(next.node, vis[next.node]));
                }
            }
        }
    }
}
