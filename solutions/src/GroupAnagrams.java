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
        HashMap<String, List<String>> hash = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            hash.putIfAbsent(sortedWord, new ArrayList<>());
            if (hash.containsKey(sortedWord))
                hash.get(sortedWord).add(strs[i]);
        }
        return new ArrayList<>(hash.values());
    }
}
