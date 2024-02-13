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
        int[] degree = new int[nc];
        boolean[] vis = new boolean[nc];
        for (int i = 0; i < nc; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pres : prereq) {
            graph[pres[1]].add(pres[0]);
            degree[pres[0]]++;
            if (pres[0] == pres[1])
                return false;
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < nc; i++) {
                if (!vis[i] && degree[i] == 0) {
                    flag = true;
                    dfs(graph, i, nc, vis, degree);
                }
            }
        }
        for (int i = 0; i < nc; i++) {
            if (!vis[i] || degree[i] < 0)
                return false;
        }
        return true;
    }

    private static void dfs(ArrayList<Integer>[] graph, int i, int nc, boolean[] vis, int[] degree) {
        if (vis[i])
            return;
        vis[i] = true;
        for (Integer vals : graph[i]) {
            degree[vals]--;
            if (degree[vals] == 0) {
                dfs(graph, vals, nc, vis, degree);
            }
        }
    }

    public static boolean canFinishBFS(int nc, int[][] prereq) {
        ArrayList<Integer>[] graph = new ArrayList[nc];
        int[] degree = new int[nc];
        LinkedList<Integer> que = new LinkedList<>();
        boolean[] vis = new boolean[nc];
        for (int i = 0; i < nc; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pres : prereq) {
            graph[pres[1]].add(pres[0]);
            degree[pres[0]]++;
        }
        for (int keys = 0; keys < nc; keys++) {
            if (degree[keys] == 0) {
                que.add(keys);
            }
        }
        while (!que.isEmpty()) {
            int size = que.size();
            for (int k = 0; k < size; k++) {
                int cur = que.poll();
                vis[cur] = true;
                for (Integer vals : graph[cur]) {
                    degree[vals]--;
                    if (degree[vals] == 0) {
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
