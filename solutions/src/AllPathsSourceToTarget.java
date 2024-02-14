import java.util.ArrayList;
import java.util.List;

/**
 * Problem URL: https://leetcode.com/problems/all-paths-from-source-to-target/description/
 * Level: Medium
 */

public class AllPathsSourceToTarget {

    private static ArrayList<List<Integer>> res;

    public static void main(String[] args) {
        // Case 1
        System.out.println(AllPathsSourceToTarget.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));

        // Case 2
        System.out.println(AllPathsSourceToTarget.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        res = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        dfs(graph, n, 0, cur);
        return res;
    }

    private static void dfs(int[][] graph, int n, int val, ArrayList<Integer> cur) {
        cur.add(val);
        if (val == n - 1) {
            res.add(new ArrayList<>(cur));
            cur.remove(Integer.valueOf(val));
            return;
        }
        for (int nei : graph[val]) {
            dfs(graph, n, nei, cur);
        }
        cur.remove(Integer.valueOf(val));
    }
}
