package whattotrack;

public class ValidAnagram {
    public static void main(String[] args) {
        // Case 1
        System.out.println(ValidAnagram.isAnagram("anagram", "nagaram"));

        // Case 2
        System.out.println(ValidAnagram.isAnagram("heart", "earth"));
    }

    public static boolean isAnagram(String str1, String str2) {

        int lenA = str1.length();
        int lenB = str2.length();
        if (lenA != lenB) return false;
        int[] freq = new int[26];
        for (char c : str1.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0) return false;
        }
        return true;
    }
}
