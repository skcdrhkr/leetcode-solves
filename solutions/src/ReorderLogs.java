import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReorderLogs {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(ReorderLogs.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));

        // Case 2
        System.out.println(Arrays.toString(ReorderLogs.reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"})));

        // Case 3
        System.out.println(Arrays.toString(ReorderLogs.reorderLogFiles(new String[]{"j mo", "5 m w", "g 07", "o 2 0", "t q h"})));
    }

    public static String[] reorderLogFiles(String[] logs) {
        ArrayList<String> digLogs = new ArrayList<>();
        ArrayList<String> letLogs = new ArrayList<>();
        for (String log : logs) {
            String[] logLine = log.split(" ");
            if (logLine[1].charAt(0) >= '0' && logLine[1].charAt(0) <= '9') {
                digLogs.add(log);
            } else {
                letLogs.add(log);
            }
        }
        Collections.sort(letLogs, (x, y) -> sortingLetters(x, y));
        int i = 0;
        for (; i < letLogs.size(); i++) {
            logs[i] = letLogs.get(i);
        }
        int j = 0;
        for (; i < logs.length; i++) {
            logs[i] = digLogs.get(j++);
        }
        return logs;
    }

    private static int sortingLetters(String x, String y) {
        String[] first = x.split(" ",2);
        String[] second = y.split(" ",2);
        int compare = first[1].compareTo(second[1]);
        if (compare != 0) {
            return compare;
        } else {
            return first[0].compareTo(second[0]);
        }
    }
}
