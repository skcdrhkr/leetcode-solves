import java.util.Arrays;

public class TaskScheduler {

    public static void main(String[] args) {
        // Case 1
        System.out.println(TaskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));

        // Case 2
        System.out.println(TaskScheduler.leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1));

        // Case 3
        System.out.println(TaskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));

        // Case 4
        System.out.println(TaskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'C', 'D', 'C', 'C', 'C'}, 3));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int[] track = new int[26];
        Integer[] sortedTasks = new Integer[26];
        for (int i = 0; i < 26; i++) {
            sortedTasks[i] = i;
        }
        int totalTasks = tasks.length;
        int taskCount = 1;
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(sortedTasks, (x, y) -> (freq[y] - freq[x]));
        while (totalTasks > 0) {
            for (int i : sortedTasks) {
                if (freq[i] != 0) {
                    freq[i]--;
                    if ((track[i] == 0) || ((taskCount - track[i]) >= n)) {
                        track[i] = taskCount;
                    } else {
                        track[i] = (track[i] + n + 1);
                    }
                    totalTasks--;
                    taskCount = track[i] + 1;
                }
            }
        }
        return taskCount - 1;
    }
}
