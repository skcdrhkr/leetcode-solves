package stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(ExclusiveTimeOfFunctions.exclusiveTime(2, Arrays.asList(new String[]{"0:start:0", "1:start:2", "1:end:5", "0:end:6"}))));

        // Case 2
        System.out.println(Arrays.toString(ExclusiveTimeOfFunctions.exclusiveTime(3, Arrays.asList(new String[]{"0:start:0", "0:end:0", "1:start:1", "1:end:1", "2:start:2", "2:end:2", "2:start:3", "2:end:3"}))));
    }

    static class Task {
        int id;
        int time;

        public Task(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public static int[] exclusiveTime(int n, List<String> logs) {

        int[] result = new int[n];
        Stack<Task> stack = new Stack<>();
        int start = 0;
        for (String log : logs) {
            String[] entry = log.split(":");
            int newId = Integer.parseInt(entry[0]);
            int time = Integer.parseInt(entry[2]);
            if ("start".equals(entry[1])) {
                if (!stack.isEmpty()) {
                    Task top = stack.peek();
                    result[top.id] += time - start;
                }
                stack.push(new Task(newId, time));
                start = time;
            } else {
                Task top = stack.pop();
                result[top.id] += time - start + 1;
                start = time + 1;
            }
        }
        return result;
    }
}
