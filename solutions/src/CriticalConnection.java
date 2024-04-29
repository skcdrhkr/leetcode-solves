import java.util.*;

public class CriticalConnection {

    int[] pre, low;
    int depth = 1;
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        pre = new int[n];
        low = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (List<Integer> conn : connections) {
            graph.get(conn.get(0)).add(conn.get(1));
            graph.get(conn.get(1)).add(conn.get(0));
        }
        dfs(0, -1);
        return result;
    }

    private void dfs(int cur, int prev) {
        pre[cur] = low[cur] = depth;
        depth++;
        for (int nxt : graph.get(cur)) {
            if (pre[nxt] == 0) {
                dfs(nxt, cur);
                low[cur] = Math.min(low[cur], low[nxt]);
            } else if (nxt != prev) {
                low[cur] = Math.min(low[cur], pre[nxt]);
            }
            if (low[nxt] > pre[cur]) {
                result.add(Arrays.asList(cur, nxt));
            }
        }
    }
}
