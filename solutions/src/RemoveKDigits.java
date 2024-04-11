public class RemoveKDigits {

    public static void main(String[] args) {
        // Case 1
        System.out.println(RemoveKDigits.removeKdigits("1432219", 3));

        // Case 2
        System.out.println(RemoveKDigits.removeKdigits("112", 1));

        // Case 3
        System.out.println(RemoveKDigits.removeKdigits("10", 2));

        // Case 4
        System.out.println(RemoveKDigits.removeKdigits("36509", 2));

        // Case 5
        System.out.println(RemoveKDigits.removeKdigits("1234567890", 9));

        // Case 6
        System.out.println(RemoveKDigits.removeKdigits("10200", 1));

        // Case 7
        System.out.println(RemoveKDigits.removeKdigits("10", 1));

        // Case 8
        System.out.println(RemoveKDigits.removeKdigits("10001", 1));
    }

    public static String removeKdigits(String num, int k) {
        int len = num.length();
        // If characters to remove is equal to length of string, we return 0
        if (k == len) return "0";

        // Creating a stack to track the previous character of String
        char[] stack = new char[len];
        int stackIndex = -1;

        for (int stringIndex = 0; stringIndex < len; stringIndex++) {
            char cur = num.charAt(stringIndex);
            // If k > 0, means we still have to remove characters
            // If the previous non-removed character of string is greater than current
            // we remove it
            while (k > 0 && stackIndex != -1 && stack[stackIndex] > cur) {
                stackIndex--;
                k--;
            }
            // We push the current character on stack
            stackIndex++;
            stack[stackIndex] = cur;
        }
        // If we have traversed whole string and k is still >0
        // It means the string character were in ascending order
        // So we remove k characters from string from last
        if (k > 0) {
            stackIndex -= k;
        }

        int nonZeroStart = 0;
        // Identifies the first non-zero character of String
        while (nonZeroStart < stackIndex && stack[nonZeroStart] == '0') nonZeroStart++;

        // if non-zero start > remaining string length
        // It is an empty string, return "0"
        if (nonZeroStart > stackIndex) return "0";
        // else return string starting from nonZeroStart till stackIndex
        return new String(stack, nonZeroStart, stackIndex - nonZeroStart + 1);
    }
}
