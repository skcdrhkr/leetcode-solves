package dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateValidIPAddresses {
    public static void main(String[] args) {
        // Case 1
        System.out.println(GenerateValidIPAddresses.generateValidIPs("255678166"));

        // Case 2
        System.out.println(GenerateValidIPAddresses.generateValidIPs("25505011535"));
    }

    private static List<String> generateValidIPs(String input) {
        List<String> result = new ArrayList<>();
        int ind = 0;
        getAllValidIPs(input, 0, 0, result, input.length(), new StringBuilder(), 0);
        return result;
    }

    private static void getAllValidIPs(String input, int index, int dots, List<String> result, int length, StringBuilder cur, int field) {

    }

}
