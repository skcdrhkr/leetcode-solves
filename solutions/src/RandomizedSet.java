/**
 * Problem URL: https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 * Level: Medium
 */

import java.util.HashSet;

class RandomizedSet {

    HashSet<Integer> set;
    int[] lst;
    int cur;

    public RandomizedSet() {
        set = new HashSet<>();
        lst = new int[200001];
        cur = 0;
    }

    public boolean insert(int val) {
        boolean ret = set.add(val);
        if (ret) {
            lst[cur] = val;
            cur += 1;
        }
        return ret;
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        boolean found = false;
        int res = -1;
        while (!found) {
            int ret = (int) (Math.random() * cur);
            if (set.contains(lst[ret])) {
                res = lst[ret];
                found = true;
            }
        }
        return res;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */