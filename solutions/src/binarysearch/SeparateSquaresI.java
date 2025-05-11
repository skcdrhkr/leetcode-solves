package binarysearch;

public class SeparateSquaresI {

    public static void main(String[] args) {
        // Case 1
        System.out.println(SeparateSquaresI.separateSquares(new int[][]{{0, 0, 1}, {2, 2, 1}}));
    }

    public static double separateSquares(int[][] squares) {
        int len = squares.length;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        for (int[] sq : squares) {
            minY = Math.min(minY, sq[1]);
            maxY = Math.max(maxY, sq[1] + sq[2]);
        }
        double lo = minY, hi = maxY, mid;
        double epsilon = 1e-5;
        while ((hi - lo) > epsilon) {
            mid = lo + (hi - lo) / 2.0;
            double[] area = getSquaresArea(squares, mid);
            if (area[0] > area[1]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }

    private static double[] getSquaresArea(int[][] squares, double split) {
        double lowerArea = 0, topArea = 0;
        for (int[] sq : squares) {
            if (sq[1] >= split) {
                topArea += (sq[2] * sq[2]);
            } else if ((sq[1] + sq[2]) <= split) {
                lowerArea += (sq[2] * sq[2]);
            } else {
                lowerArea += (sq[2] * (split - sq[1]));
                topArea += (sq[2] * ((sq[1] + sq[2]) - split));
            }
        }
        return new double[]{topArea, lowerArea};
    }
}
