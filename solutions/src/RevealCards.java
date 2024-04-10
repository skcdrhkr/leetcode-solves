import java.util.Arrays;
import java.util.LinkedList;

public class RevealCards {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(RevealCards.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));

        // Case 2
        System.out.println(Arrays.toString(RevealCards.deckRevealedIncreasing(new int[]{1, 1000})));

        // Case 3
        System.out.println(Arrays.toString(RevealCards.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 19, 7})));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;
        Arrays.sort(deck);
        int[] result = new int[len];
        int indexResult = 0, indexOrig = 0;
        boolean filled = false;
        while (indexOrig < len) {
            if (result[indexResult] == 0) {
                if (!filled) {
                    result[indexResult] = deck[indexOrig++];
                }
                filled = !filled;
            }
            indexResult = (indexResult + 1) % len;
        }
        return result;
    }

    public static int[] deckRevealedIncreasingViaQueue(int[] deck) {
        int len = deck.length;
        Arrays.sort(deck);
        int ind = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) queue.offerLast(i);
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[queue.pollFirst()] = deck[i];
            queue.offerLast(queue.pollFirst());
        }
        return res;
    }
}