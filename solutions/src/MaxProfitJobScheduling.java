import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
 * Level: Hard
 */

public class MaxProfitJobScheduling {

    static class Job implements Comparable<Job> {
        int st;
        int en;
        int val;

        public Job(int st, int en, int val) {
            this.st = st;
            this.en = en;
            this.val = val;
        }

        @Override
        public int compareTo(Job o) {
            if (this.en != o.en) {
                return this.en - o.en;
            } else {
                return this.st - o.st;
            }
        }
    }

    public static void main(String[] args) {
        // Case 1
        System.out.println(MaxProfitJobScheduling.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
        // Case 2
        System.out.println(MaxProfitJobScheduling.jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
        // Case 3
        System.out.println(MaxProfitJobScheduling.jobScheduling(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4}));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int res = 0, n = startTime.length;
        Job[] jobs = new Job[n];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs);
        for (int i = 0; i < n; i++) {
            int leftIndexNonOverLap = upperBound(jobs, i, jobs[i].st);
            dp[i + 1] = Math.max(dp[i], dp[leftIndexNonOverLap] + jobs[i].val);
        }
        return dp[n];
    }

    private static int upperBound(Job[] jobs, int i, int st) {
        int lo = 0, hi = i, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (jobs[mid].en <= st) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }


}
