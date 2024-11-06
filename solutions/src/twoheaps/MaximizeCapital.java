package twoheaps;

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
        System.out.println(MaximizeCapital.maximumCapitalTwoHeaps(1, 2, new int[]{1, 2, 2, 3}, new int[]{2, 4, 6, 8}));

        // Case 2
        System.out.println(MaximizeCapital.maximumCapitalTwoHeaps(2, 2, new int[]{1, 2, 3, 4}, new int[]{1, 3, 5, 7}));

        // Case 3
        System.out.println(MaximizeCapital.maximumCapitalTwoHeaps(1, 3, new int[]{1, 2, 3, 11, 19, 21}, new int[]{2, 7, 9, 16, 17, 18}));
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
        int len = capitals.length;

        PriorityQueue<Project> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x.capital));
        PriorityQueue<Project> maxProfitHeap = new PriorityQueue<>((x, y) -> y.profit - x.profit);

        for (int i = 0; i < len; i++) {
            minCapitalHeap.add(new Project(profits[i], capitals[i]));
        }

        while (k > 0) {
            while (!minCapitalHeap.isEmpty() && c >= minCapitalHeap.peek().capital) {
                maxProfitHeap.add(minCapitalHeap.poll());
            }
            if (!maxProfitHeap.isEmpty()) {
                c += maxProfitHeap.poll().profit;
            }
            k -= 1;
        }
        return c;
    }
}
