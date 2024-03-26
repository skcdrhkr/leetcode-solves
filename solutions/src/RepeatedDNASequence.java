import java.util.*;

public class RepeatedDNASequence {

    public static void main(String[] args) {
        // Case 1
        System.out.println(RepeatedDNASequence.findRepeatedSequences("AAAAACCCCCAAAAACCCCCC", 8));

        // Case 2
        System.out.println(RepeatedDNASequence.findRepeatedSequences("GGGGGGGGGGGGGGGGGGGGGGGGG", 9));

        // Case 3
        System.out.println(RepeatedDNASequence.findRepeatedSequences("TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", 10));
    }

    public static List<String> findRepeatedSequences(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);
        int length = s.length();
        if (k > length) return new ArrayList<>();
        if (k == length) return List.of(s);

        int rollHash = 0;
        Set<String> result = new HashSet<>();
        int first = 0, second = 0;
        while (second < k) {
            rollHash += (map.get(s.charAt(second)) * (int) (Math.pow(4, k - 1 - second)));
            second += 1;
        }
        Set<Integer> track = new HashSet<>();
        track.add(rollHash);
        while (second < length) {
            // Subtracting outgoing character hash
            rollHash -= (map.get(s.charAt(first)) * (int) Math.pow(4, k - 1));
            // Shifting the current window hash
            rollHash *= 4;
            // Adding new incoming character hash
            rollHash += (map.get(s.charAt(second)));
            if (track.contains(rollHash)) {
                result.add(s.substring(first + 1, second + 1));
            } else {
                track.add(rollHash);
            }
            first++;
            second++;
        }
        return new ArrayList<>(result);
    }
}
