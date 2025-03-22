package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

    public static void main(String[] args) {
        // Case 1
        System.out.println(WordBreak2.wordBreak("aaaaaaa", List.of("aaa", "aaaa", "a")));

        // Case 2
        System.out.println(WordBreak2.wordBreak("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple")));
    }

    private static void breakingWords(String s, Set<String> dict, int index, int len,
                                      List<String> result, ArrayList<String> builder) {
        if (index >= len) {
            result.add(String.join(" ", builder));
            return;
        }
        for (int j = index + 1; j <= len; j++) {
            String cur = s.substring(index, j);
            if (dict.contains(cur)) {
                builder.add(cur);
                breakingWords(s, dict, j, len, result, builder);
                builder.remove(builder.size() - 1);
            }
        }
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int len = s.length();
        List<String> result = new ArrayList<>();
        breakingWords(s, dict, 0, len, result, new ArrayList<>());
        return result;
    }
}
