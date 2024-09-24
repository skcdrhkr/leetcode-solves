import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaximizeCapital {

    static class Project {
        int profit;
        int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public static void main(String[] args) {
        // Case 1
        System.out.println(MaximizeCapital.maximumCapital(1, 2, new int[]{1, 2, 2, 3}, new int[]{2, 4, 6, 8}));

        // Case 2
        System.out.println(MaximizeCapital.maximumCapital(2, 2, new int[]{1, 2, 3, 4}, new int[]{1, 3, 5, 7}));

        // Case 3
        System.out.println(MaximizeCapital.maximumCapital(1, 3, new int[]{1, 2, 3, 11, 19, 21}, new int[]{2, 7, 9, 16, 17, 18}));
    }

    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {

        // Replace this placeholder return statement with your code
        int len = capitals.length;
        int capital = c;
        PriorityQueue<Project> maxHeap = new PriorityQueue<>((x, y) -> y.profit - x.profit);
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            projects.add(new Project(profits[i], capitals[i]));
        }
        projects.sort(Comparator.comparingInt(x -> x.capital));
        int ind = 0;
        while (k > 0) {
            while (ind < len && projects.get(ind).capital <= capital) {
                maxHeap.add(projects.get(ind));
                ind++;
            }
            if (maxHeap.isEmpty()) break;
            capital += maxHeap.poll().profit;
            k -= 1;
        }

        return capital;
    }

    public static int maximumCapitalTwoHeaps(int c, int k, int[] capitals, int[] profits) {

        // Replace this placeholder return statement with your code
        int len = capitals.length;
        int capital = c;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(x -> capitals[x]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> profits[y] - profits[x]);

        for (int i = 0; i < len; i++) {
            minHeap.add(i);
        }
        while (k > 0) {
            while (!minHeap.isEmpty() && capitals[minHeap.peek()] <= capital) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.isEmpty()) break;
            capital += profits[maxHeap.poll()];
            k -= 1;
        }

        return capital;
    }
}
