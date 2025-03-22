/**
 * Leetcode: https://leetcode.com/problems/combination-sum/description/
 */

package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        // Case 0
        System.out.println(CombinationSum.combinationSum(new int[]{2, 3, 4}, 6));

        // Case 1
        System.out.println(CombinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7));

        // Case 2
        System.out.println(CombinationSum.combinationSum(new int[]{2, 3, 5}, 8));

        // Case 3
        System.out.println(CombinationSum.combinationSum(new int[]{2}, 1));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>(target+1);

        dp.add(new ArrayList<>());
        dp.getFirst().add(new ArrayList<>());

        for (int sum = 1; sum <= target; sum++) {
            dp.add(new ArrayList<>());
            for (int ind = 0; ind < candidates.length; ind++) {
                if (candidates[ind] <= sum) {
                    List<List<Integer>> prev = dp.get(sum - candidates[ind]);
                    for (List<Integer> lst : prev) {
                        List<Integer> temp = new ArrayList<>(lst);
                        temp.add(candidates[ind]);
                        Collections.sort(temp);
                        if (!dp.get(sum).contains(temp)) {
                            dp.get(sum).add(temp);
                        }
                    }
                }
            }
        }
        return dp.get(target);
    }

    public static List<List<Integer>> combinationSumBacktracking(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getCombinationSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void getCombinationSum(int[] candidates, int target, int index, ArrayList<Integer> cur, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        if (candidates[index] <= target) {
            cur.add(candidates[index]);
            getCombinationSum(candidates, target - candidates[index], index, cur, result);
            cur.remove(Integer.valueOf(candidates[index]));
        }
        getCombinationSum(candidates, target, index + 1, cur, result);
    }
}
