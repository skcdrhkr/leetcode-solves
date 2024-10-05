package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathsInMazeLeadToSameRoom {

    public static void main(String[] args) {
        // Case 1
        System.out.println(PathsInMazeLeadToSameRoom.numberOfPaths(5, new int[][]{{1, 2}, {5, 2}, {4, 1}, {2, 4}, {3, 1}, {3, 4}}));

        // Case 2
        System.out.println(PathsInMazeLeadToSameRoom.numberOfPaths(5, new int[][]{{1, 2}, {5, 2}, {4, 1}, {2, 4}, {3, 1}, {3, 4}, {1, 5}}));

        // Case 3
        System.out.println(PathsInMazeLeadToSameRoom.numberOfPaths(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

    public static int numberOfPaths(int n, int[][] corridors) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int cycles = 0;
        for (int[] corridor : corridors) {
            int x = corridor[0];
            int y = corridor[1];
            graph.computeIfAbsent(x, k -> new HashSet<>()).add(y);
            graph.computeIfAbsent(y, k -> new HashSet<>()).add(x);
            cycles += getIntersection(graph.get(x), graph.get(y));
        }
        return cycles;
    }

    private static int getIntersection(Set<Integer> nodeA, Set<Integer> nodeB) {
        int value = 0;
        for (Integer num : nodeA) {
            if (nodeB.contains(num))
                value += 1;
        }
        return value;
    }

    public static int numberOfPathsWithoutSet(int n, int[][] corridors) {
        int[][] graph = new int[n + 1][n + 1];
        int cycles = 0;
        for (int[] corridor : corridors) {
            int x = corridor[0];
            int y = corridor[1];
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (graph[i][j] == 1) {
                    for (int k = j + 1; k <= n; k++) {
                        if (graph[i][k] == 1 && graph[j][k] == 1) cycles++;
                    }
                }
            }
        }
        return cycles;
    }
}
