/**
 * Problem URL: https://leetcode.com/problems/sequential-digits/description
 * Level: Medium
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SequentialDigits {

    public static void main(String[] args) {
        // Case 1
        System.out.println(SequentialDigits.sequentialDigits(100, 300));

        // Case 2
        System.out.println(SequentialDigits.sequentialDigits(1000, 13000));
    }

    public static List<Integer> sequentialDigitsIterative(int low, int high) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= 8; i++)
            qu.add(i);
        int top, cur, last, nxt;
        while (!qu.isEmpty()) {
            top = qu.pollFirst();
            last = top % 10;
            nxt = last + 1;
            if (nxt != 10) {
                cur = (top * 10) + nxt;
                if (cur >= low && cur <= high) {
                    res.add(cur);
                    qu.add(cur);
                } else if (cur < low) {
                    qu.add(cur);
                }
            }
        }
        return res;
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            addDigit(low, high, res, i);
        }
        Collections.sort(res);
        return res;
    }

    private static void addDigit(int low, int hi, ArrayList<Integer> res, int d) {
        if (d > hi)
            return;
        if (d >= low) {
            res.add(d);
        }
        if (d % 10 != 9)
            addDigit(low, hi, res, d * 10 + ((d % 10) + 1));
    }
}
