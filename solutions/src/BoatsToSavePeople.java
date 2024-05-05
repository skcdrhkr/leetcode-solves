public class BoatsToSavePeople {

    public static void main(String[] args) {
        // Case 1
        System.out.println(BoatsToSavePeople.numRescueBoats(new int[]{1, 2}, 3));

        // Case 2
        System.out.println(BoatsToSavePeople.numRescueBoats(new int[]{3, 2, 2, 1}, 3));

        // Case 3
        System.out.println(BoatsToSavePeople.numRescueBoats(new int[]{3, 5, 3, 4}, 5));


    }

    public static int numRescueBoats(int[] people, int limit) {
        int[] hash = new int[30001];
        for (int cur : people) {
            hash[cur]++;
        }
        int res = 0;
        for (int cur : people) {
            if (hash[cur] != 0) {
                res++;
                hash[cur]--;
                if (cur < limit) {
                    int k = limit - cur;
                    while (k > 0) {
                        if (hash[k] != 0) {
                            hash[k] -= 1;
                            break;
                        }
                        k -= 1;
                    }
                }
            }
        }
        return res;
    }
}
