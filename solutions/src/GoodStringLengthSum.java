public class GoodStringLengthSum {

    public static void main(String[] args) {
        // Case 1
        System.out.println(GoodStringLengthSum.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));

        // Case 2
        System.out.println(GoodStringLengthSum.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }

    public static int countCharacters(String[] words, String chars) {
        int[] charFreq = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charFreq[chars.charAt(i) - 'a']++;
        }
        int res = 0;
        for (String cur : words) {
            int[] curFreq = new int[26];
            for (int i = 0; i < cur.length(); i++) {
                curFreq[cur.charAt(i) - 'a']++;
            }
            int k = 0;
            for (k = 0; k < 26; k++) {
                if (curFreq[k] > charFreq[k]) break;
            }
            if (k == 26) res += cur.length();
        }
        return res;
    }
}
