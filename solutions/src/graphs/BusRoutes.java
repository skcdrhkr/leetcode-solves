package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusRoutes {

    record Route(int to, int color) {
    }

    public static void main(String[] args) {
        // Case 1
        System.out.println(BusRoutes.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Route>> graph = new HashMap<>();
        if (source == target) return 0;
        for (int k = 0; k < routes.length; k++) {
            int[] route = routes[k];
            for (int i = 1; i < route.length; i++) {
                int x = route[i - 1];
                int y = route[i];
                graph.computeIfAbsent(x, m -> new ArrayList<>()).add(new Route(y, k));
            }
        }
        return getMinBusesToDest(graph, source, target, 1);
    }

    private static int getMinBusesToDest(Map<Integer, List<Route>> graph, int source, int target, int result) {
        if (source == target) return result;
        List<Route> neigh = graph.get(source);
        return 0;
    }
}
