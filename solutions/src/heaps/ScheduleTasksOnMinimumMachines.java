package heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ScheduleTasksOnMinimumMachines {

    public static void main(String[] args) {
        List<List<Integer>> case1 = new ArrayList<>();
        case1.add(List.of(12, 13));
        case1.add(List.of(13, 15));
        case1.add(List.of(17, 20));
        case1.add(List.of(13, 14));
        case1.add(List.of(19, 21));
        case1.add(List.of(18, 20));
        System.out.println(ScheduleTasksOnMinimumMachines.tasks(case1));

        List<List<Integer>> case2 = new ArrayList<>();
        case2.add(List.of(1, 7));
        case2.add(List.of(8, 13));
        case2.add(List.of(5, 6));
        case2.add(List.of(10, 14));
        case2.add(List.of(6, 7));
        System.out.println(ScheduleTasksOnMinimumMachines.tasks(case2));

        int[][] case3 = new int[][]{{240, 545}, {0, 355}, {0, 505}, {290, 622}, {422, 616}, {0, 990}, {772, 808}, {41, 476}, {7, 144}, {0, 509}, {87, 130}, {0, 190}, {9, 25}, {267, 301}, {0, 332}, {0, 423}, {49, 81}, {0, 386}, {0, 79}, {0, 776}, {0, 455}, {448, 612}, {352, 571}, {156, 262}, {0, 438}, {72, 416}, {0, 225}, {31, 701}, {11, 45}, {244, 534}};
        List<List<Integer>> case3List = new ArrayList<>();
        for (int[] cur : case3) {
            case3List.add(List.of(cur[0], cur[1]));
        }
        System.out.println(ScheduleTasksOnMinimumMachines.tasks(case3List));
    }

    public static int tasks(List<List<Integer>> tasksList) {
        int result = 1;
        tasksList.sort((x, y) -> x.get(0).equals(y.get(0)) ? x.get(1) - y.get(1) : x.get(0) - y.get(0));
        PriorityQueue<List<Integer>> minHeapTasks = new PriorityQueue<>(Comparator.comparingInt(x -> x.get(1)));
        for (List<Integer> curTask : tasksList) {
            int curStart = curTask.get(0);
            while (!minHeapTasks.isEmpty() && minHeapTasks.peek().get(1) <= curStart) {
                minHeapTasks.poll();
            }
            minHeapTasks.add(curTask);
            result = Math.max(result, minHeapTasks.size());
        }
        return result;
    }

    public static int tasksEducativeTwoHeaps(List<List<Integer>> tasksList) {
        int optimalMachines = 0;

        PriorityQueue<int[]> machinesAvailable = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> tasksQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (List<Integer> task : tasksList) {
            tasksQueue.offer(new int[]{
                    task.get(0), task.get(1)
            });
        }

        while (!tasksQueue.isEmpty()) {
            int[] task = tasksQueue.poll();
            int[] machineInUse;
            if (!machinesAvailable.isEmpty() && task[0] >= machinesAvailable.peek()[0]) {
                machineInUse = machinesAvailable.poll();
                machineInUse = new int[]{
                        task[1], machineInUse[1]
                };
            } else {
                optimalMachines += 1;
                machineInUse = new int[]{
                        task[1], optimalMachines
                };
            }
            machinesAvailable.offer(machineInUse);
        }
        return optimalMachines;
    }

}
