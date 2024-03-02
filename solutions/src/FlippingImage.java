/**
 * Online Assessment : Easy
 */

public class FlippingImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int lo, hi, temp;
        for (int i = 0; i < n; i++) {
            lo = 0;
            hi = n - 1;
            while (lo < hi) {
                temp = image[i][lo];
                image[i][lo] = image[i][hi];
                image[i][hi] = temp;
                image[i][lo] = (image[i][lo] == 1) ? 0 : 1;
                image[i][hi] = (image[i][hi] == 1) ? 0 : 1;
                lo++;
                hi--;
            }
            if (lo == hi) {
                image[i][hi] = (image[i][hi] == 1) ? 0 : 1;
            }
        }
        return image;
    }
}
