package greedy;

import java.util.Arrays;

public class MinimizeDevCycle {

    static class Task {
        int devCycle;
        int leadCycle;

        public Task(int devCycle, int leadCycle) {
            this.devCycle = devCycle;
            this.leadCycle = leadCycle;
        }
    }

    public static void main(String[] args) {
        // Case 1
        System.out.println(MinimizeDevCycle.getMinDevCycle(new int[]{3, 4, 5, 9}, new int[]{3, 2, 5, 5}));

        // Case 2
        System.out.println(MinimizeDevCycle.getMinDevCycle(new int[]{1, 5, 7, 2}, new int[]{1, 1, 3, 3}));
    }

    public static int getMinDevCycle(int[] devTime, int[] leadTime) {
        int len = devTime.length;
        Task[] devTasks = new Task[len];
        for (int i = 0; i < len; i++) {
            devTasks[i] = new Task(devTime[i], leadTime[i]);
        }
        Arrays.sort(devTasks, (x, y) -> (y.devCycle - x.devCycle));
        int result = devTasks[0].devCycle;
        int leadTimeTillNow = devTasks[0].leadCycle;
        for (int i = 1; i < len; i++) {
            result = Math.min(result, Math.max(leadTimeTillNow, devTasks[i].devCycle));
            if (leadTimeTillNow > devTasks[i].devCycle) break; // Optimizing Step
            leadTimeTillNow += devTasks[i].leadCycle;
        }
        return result;
    }
}
