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
        int maxFreq = 0;
        for (char c : tasks) {
            freq[c - 'A']++;
            if (freq[c - 'A'] > maxFreq) maxFreq = freq[c - 'A'];
        }
        int possibleIdle = (maxFreq - 1) * n;
        boolean skip = true;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                int cur = freq[i];
                if (freq[i] == maxFreq && skip) {
                    skip = false;
                    continue;
                }
                possibleIdle -= Math.min(cur, maxFreq - 1);
                if (possibleIdle < 0) {
                    possibleIdle = 0;
                    break;
                }
            }
        }
        return possibleIdle + len;
    }
}
