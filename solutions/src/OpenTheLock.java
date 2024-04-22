import java.util.HashSet;
import java.util.LinkedList;

public class OpenTheLock {

    public static void main(String[] args) {
        // Case 1
        System.out.println(OpenTheLock.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));

        // Case 2
        System.out.println(OpenTheLock.openLock(new String[]{"8888"}, "0009"));

        // Case 3
        System.out.println(OpenTheLock.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
    }

    public static int openLock(String[] deadends, String target) {
        HashSet<String> ends = new HashSet<>();
        for (String cur : deadends) {
            ends.add(cur);
        }
        return unlockViaBFS("0000", target, ends, 0);
    }

    private static int unlockViaBFS(String start, String target, HashSet<String> deadends, int move) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add(start);
        String cur;
        String[] next;
        deadends.add(start);
        while (!queue.isEmpty()) {
            int siz = queue.size();
            for (int ind = 0; ind < siz; ind++) {
                cur = queue.pollFirst();
                if (target.equals(cur)) return move;
                for (int i = 0; i < cur.length(); i++) {
                    next = getNextMove(cur, i);
                    if (!deadends.contains(next[0])) {
                        deadends.add(next[0]);
                        queue.add(next[0]);
                    }
                    if (!deadends.contains(next[1])) {
                        deadends.add(next[1]);
                        queue.add(next[1]);
                    }
                }
            }
            move++;
        }
        return -1;
    }

    private static String[] getNextMove(String cur, int i) {
        char[] arr = cur.toCharArray();
        String[] next = new String[2];
        char orig = arr[i];
        if (arr[i] == '0') {
            arr[i] = '9';
        } else {
            arr[i] = (char) (arr[i] - 1);
        }
        next[0] = new String(arr);
        arr[i] = orig;
        if (arr[i] == '9') {
            arr[i] = '0';
        } else {
            arr[i] = (char) (arr[i] + 1);
        }
        next[1] = new String(arr);
        return next;
    }
}
