import java.util.ArrayList;
import java.util.PriorityQueue;

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
        int len = tasks.length;
        if (n == 0) return len;
        int[] freq = new int[26];
        int[] prevIndex = new int[26];

        for (char c : tasks) {
            freq[c - 'A']++;
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> freq[b - 'A'] - freq[a - 'A']);
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                heap.add((char) (i + 'A'));
            }
        }
        int result = 0;
        int remain = len;
        ArrayList<Character> tempList;
        boolean flag;
        while (remain > 0) {
            tempList = new ArrayList<>();
            flag = false;
            while (!heap.isEmpty()) {
                char top = heap.poll();
                if (prevIndex[top - 'A'] == 0 || (result - prevIndex[top - 'A'] >= n)) {
                    result++;
                    prevIndex[top - 'A'] = result;
                    freq[top - 'A'] -= 1;
                    if (freq[top - 'A'] != 0) heap.add(top);
                    remain -= 1;
                    flag = true;
                    break;
                } else {
                    tempList.add(top);
                }
            }
            if (!flag) {
                result += 1;
            }
            heap.addAll(tempList);
        }
        return result;
    }
}
