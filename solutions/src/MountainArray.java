public class MountainArray {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MountainArray.validMountainArray(new int[]{2, 1}));

        // Case 2
        System.out.println(MountainArray.validMountainArray(new int[]{3, 5, 5}));

        // Case 3
        System.out.println(MountainArray.validMountainArray(new int[]{0, 3, 2, 1}));

        // Case 4
        System.out.println(MountainArray.validMountainArray(new int[]{5,6,7,3,1}));
    }

    public static boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if (len < 3) return false;
        boolean flip = false;
        if (arr[1] < arr[0] || arr[len - 1] > arr[len - 2]) return false;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) return false;
            if (arr[i] > arr[i - 1] && flip) return false;
            if (arr[i] < arr[i - 1]) {
                if (!flip) {
                    flip = true;
                }
            }
        }
        return true;
    }
}
