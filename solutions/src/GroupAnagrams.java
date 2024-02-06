/**
 * Problem URL: https://leetcode.com/problems/group-anagrams/description/
 * Level: Medium
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(GroupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(GroupAnagrams.groupAnagrams(new String[]{""}));
        System.out.println(GroupAnagrams.groupAnagrams(new String[]{"a"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        Arrays.stream(strs).forEach(s -> {
            byte[] bts = s.getBytes();
            Arrays.sort(bts);
            String cur = new String(bts);
            res.putIfAbsent(cur,new ArrayList<>());
            res.get(cur).add(s);
        });
        return new ArrayList<>(res.values());
    }
}
