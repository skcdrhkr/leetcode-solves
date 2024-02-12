/**
 * Problem URL: https://leetcode.com/problems/course-schedule/description/
 * Level: Medium
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class CourseSchedule {

    public static void main(String[] args) {
        // Case 1
        System.out.println(CourseSchedule.canFinish(2, new int[][]{{1, 0}}));

        // Case 2
        System.out.println(CourseSchedule.canFinish(2, new int[][]{{1, 0}, {0, 1}}));

        // Case 3
        System.out.println(CourseSchedule.canFinish(5, new int[][]{{2, 3}, {2, 1}, {4, 3}, {0, 2}, {0, 4}}));
    }

    public static boolean canFinish(int nc, int[][] prereq) {
        ArrayList<Integer>[] graph = new ArrayList[nc];
        ArrayList<Integer>[] revgraph = new ArrayList[nc];
        LinkedList<Integer> que = new LinkedList<>();
        boolean[] vis = new boolean[nc];
        for (int i = 0; i < nc; i++) {
            graph[i] = new ArrayList<>();
            revgraph[i] = new ArrayList<>();
        }
        for (int[] pres : prereq) {
            graph[pres[0]].add(pres[1]);
            revgraph[pres[1]].add(pres[0]);
        }
        for (int keys = 0; keys < nc; keys++) {
            if (graph[keys].isEmpty()) {
                que.add(keys);
            }
        }
        while (!que.isEmpty()) {
            int size = que.size();
            for (int k = 0; k < size; k++) {
                int cur = que.poll();
                vis[cur] = true;
                for (Integer vals : revgraph[cur]) {
                    graph[vals].remove(Integer.valueOf(cur));
                    if (graph[vals].isEmpty()) {
                        que.add(vals);
                    }
                }
            }
        }
        for (int i = 0; i < nc; i++) {
            if (!vis[i])
                return false;
        }
        return true;
    }
}
