import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RelativeSortArray {
    public static void main(String[] args) {

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] order = new int[1001];
        Arrays.fill(order,-1);
        for (int i = 0; i < arr2.length; i++) {
            order[arr2[i]] = i;
        }
        List<Integer> result = Arrays.stream(arr1).boxed().sorted((x, y) -> {
            if (order[x] != -1 && order[y] != -1) {
                return order[x] - order[y];
            } else if (order[x] != -1 && order[y] == -1) {
                return -1;
            } else if (order[x] == -1 && order[y] != -1) {
                return 1;
            } else {
                return x - y;
            }
        }).toList();
        int[] answer = new int[arr1.length];
        for(int i=0;i<arr1.length;i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
