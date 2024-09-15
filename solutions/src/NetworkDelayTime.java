import java.util.*;

public class NetworkDelayTime {

    static class Edge {
        public int node;
        public int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
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
        HashMap<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new Edge(time[1], time[2]));
        }
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        sendTheSignal(graph, k, visited);
        int minTime = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == Integer.MAX_VALUE) return -1;
            minTime = Math.max(minTime, visited[i]);
        }
        return minTime;
    }

    private static void sendTheSignal(HashMap<Integer, List<Edge>> graph, int k, int[] visited) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
        pq.add(new Edge(k, 0));
        visited[k] = 0;
        while (!pq.isEmpty()) {
            Edge top = pq.poll();
            List<Edge> neigh = graph.getOrDefault(top.node, new ArrayList<>());
            for (Edge edge : neigh) {
                if (visited[edge.node] > top.weight + edge.weight) {
                    visited[edge.node] = top.weight + edge.weight;
                    pq.add(new Edge(edge.node, visited[edge.node]));
                }
            }
        }
    }
}
