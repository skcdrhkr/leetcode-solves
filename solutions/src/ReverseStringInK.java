public class ReverseStringInK {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ReverseStringInK.reverseStr("abcdefg", 2));

        // Case 2
        System.out.println(ReverseStringInK.reverseStr("abcd", 2));

        // Case 3
        System.out.println(ReverseStringInK.reverseStr("abcdefghijklmn",3));
    }

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0, right;
        char temp;
        while (left < len) {
            right = (left + k - 1) >= len ? (len - 1) : (left + k - 1);
            int i = left, j = right;
            while (i < j) {
                temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
            left = right + k + 1;
        }
        return new String(chars);
    }
}
