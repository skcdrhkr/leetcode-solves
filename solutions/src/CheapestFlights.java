import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class CheapestFlights {

    public static void main(String[] args) {
        // Case 1
        System.out.println(CheapestFlights.findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1));

        // Case 2
        System.out.println(CheapestFlights.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));

        // Case 3
        System.out.println(CheapestFlights.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));

        // Case 4
        System.out.println(CheapestFlights.findCheapestPrice(15, new int[][]{{10, 14, 43}, {1, 12, 62}, {4, 2, 62}, {14, 10, 49}, {9, 5, 29}, {13, 7, 53}, {4, 12, 90}, {14, 9, 38}, {11, 2, 64}, {2, 13, 92}, {11, 5, 42}, {10, 1, 89}, {14, 0, 32}, {9, 4, 81}, {3, 6, 97}, {7, 13, 35}, {11, 9, 63}, {5, 7, 82}, {13, 6, 57}, {4, 5, 100}, {2, 9, 34}, {11, 13, 1}, {14, 8, 1}, {12, 10, 42}, {2, 4, 41}, {0, 6, 55}, {5, 12, 1}, {13, 3, 67}, {3, 13, 36}, {3, 12, 73}, {7, 5, 72}, {5, 6, 100}, {7, 6, 52}, {4, 7, 43}, {6, 3, 67}, {3, 1, 66}, {8, 12, 30}, {8, 3, 42}, {9, 3, 57}, {12, 6, 31}, {2, 7, 10}, {14, 4, 91}, {2, 3, 29}, {8, 9, 29}, {2, 11, 65}, {3, 8, 49}, {6, 14, 22}, {4, 6, 38}, {13, 0, 78}, {1, 10, 97}, {8, 14, 40}, {7, 9, 3}, {14, 6, 4}, {4, 8, 75}, {1, 6, 56}}, 1, 4, 10));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Cost>[] graph = new ArrayList[n];
        int len = flights.length;
        if (len == 0) return -1;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flt : flights) {
            graph[flt[0]].add(new Cost(flt[1], flt[2]));
        }
        int[] vis = new int[n];
        Arrays.fill(vis, Integer.MAX_VALUE);
        LinkedList<Cost> que = new LinkedList<>();
        que.add(new Cost(src, 0));
        vis[src] = 0;
        while (!que.isEmpty()) {
            int sz = que.size();
            for (int i = 0; i < sz; i++) {
                Cost cur = que.poll();
                {
                    if (k >= 0) {
                        for (Cost cost : graph[cur.dest]) {
                            if (cur.price != Integer.MAX_VALUE) {
                                if (cost.price + cur.price < vis[cost.dest]) {
                                    vis[cost.dest] = cost.price + cur.price;
                                    que.add(new Cost(cost.dest, vis[cost.dest]));
                                }
                            } else {
                                vis[cost.dest] = cost.price;
                                que.add(new Cost(cost.dest, vis[cost.dest]));
                            }
                        }
                    }
                }
            }
            k -= 1;
        }
        return vis[dst] == Integer.MAX_VALUE ? -1 : vis[dst];
    }

    static class Cost {
        int dest;
        int price;

        public Cost(int dest, int price) {
            this.dest = dest;
            this.price = price;
        }
    }
}
