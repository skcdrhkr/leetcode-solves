/**
 * Problem URL: https://leetcode.com/problems/perfect-squares/description
 * Level: Medium
 */

public class PerfectSquares {

    public static void main(String[] args) {
        // Case 1
        System.out.println(PerfectSquares.numSquares(22));

        // Case 2
        System.out.println(PerfectSquares.numSquares(1000));
    }
    public static int numSquares(int n) {
        int  res = 0,temp;
        int ind = binSearch(1,100,n);
        int[][] dp = new int[10001][101];
        return minSumSquare(n,ind,dp);
    }

    private static int minSumSquare(int tar, int ind, int[][] dp) {
        if(tar==0)
            return 0;
        if(tar<0 || ind<1)
            return Integer.MAX_VALUE;
        if(dp[tar][ind]!=0)
            return dp[tar][ind];

        if(ind*ind==tar)
            return 1;
        int cur,nexind;
        if(ind*ind>tar) {
            nexind = binSearch(0,ind-1,tar);
            cur = minSumSquare(tar,nexind,dp);
        } else {
            int tmp = minSumSquare(tar-(ind*ind),ind,dp);
            if(tmp!=Integer.MAX_VALUE)
                tmp+=1;
            nexind = binSearch(0,ind-1,tar);
            cur = Math.min(tmp,minSumSquare(tar,nexind,dp));
        }
        dp[tar][ind]=cur;
        return cur;
    }

    private static int binSearch(int lo, int hi, int tar) {
        int mid;
        while(lo<hi) {
            mid = (hi+lo+1)/2;
            if((mid*mid)>tar) {
                hi=mid-1;
            } else {
                lo=mid;
            }
        }
        return lo;
    }
}
