import java.util.ArrayList;

public class LeadToCityZero {

    static int result = 0;

    public static void main(String[] args) {
        // Case 1
        System.out.println(LeadToCityZero.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));

        // Case 2
        System.out.println(LeadToCityZero.minReorder(5, new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}}));

        // Case 3
        System.out.println(LeadToCityZero.minReorder(3, new int[][]{{1, 0}, {2, 0}}));
    }

    public static int minReorder(int n, int[][] conn) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int x, y;
        result = 0;
        for (int i = 0; i < conn.length; i++) {
            x = conn[i][0];
            y = conn[i][1];
            graph[x + 1].add(y + 1);
            graph[y + 1].add((x + 1) * -1);
        }
        boolean[] vis = new boolean[n + 1];
        dfs(graph, 1, vis);
        return result;
    }

    private static void dfs(ArrayList<Integer>[] graph, int cur, boolean[] vis) {
        int next;
        vis[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) {
            next = graph[cur].get(i);
            if (!vis[Math.abs(next)]) {
                if (next > 0) {
                    result += 1;
                }
                dfs(graph, Math.abs(next), vis);
            }
        }
    }
}
