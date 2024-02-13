import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem URL: https://leetcode.com/problems/course-schedule-ii/description/
 * Level: Medium
 */


public class CourseSchedule2 {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(CourseSchedule2.findOrder(2, new int[][]{{1, 0}})));

        // Case 2
        System.out.println(Arrays.toString(CourseSchedule2.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));

        // Case 3
        System.out.println(Arrays.toString(CourseSchedule2.findOrder(5, new int[][]{{2, 3}, {2, 1}, {4, 3}, {0, 2}, {0, 4}})));

        // Case 4
        System.out.println(Arrays.toString(CourseSchedule2.findOrder(1, new int[][]{})));
    }

    public static int[] findOrder(int nc, int[][] prereq) {
        ArrayList<Integer>[] graph = new ArrayList[nc];
        int[] degree = new int[nc];
        LinkedList<Integer> que = new LinkedList<>();
        int[] res = new int[nc];
        int count = 0;
        boolean[] vis = new boolean[nc];
        if (prereq.length == 0) {
            for (int i = 0; i < nc; i++)
                res[count++] = i;
            return res;
        }
        for (int i = 0; i < nc; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pres : prereq) {
            graph[pres[1]].add(pres[0]);
            degree[pres[0]]++;
            if(pres[0]==pres[1])
                return new int[0];
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
                res[count++] = cur;
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
                return new int[0];
        }
        return res;
    }

}
