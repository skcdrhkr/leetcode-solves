package topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        // Case 1
        System.out.println(KClosestPointsToOrigin.kClosest(new Point[]{new Point(-1, -3), new Point(-4, -5), new Point(-2, -2), new Point(-2, -3)}, 3));

        // Case 2
        System.out.println(KClosestPointsToOrigin.kClosest(new Point[]{new Point(1, 3), new Point(-2, 4), new Point(2, -1), new Point(-2, 2), new Point(5, -3), new Point(3, -2)}, 3));
    }

    public static List<Point> kClosest(Point[] points, int k) {
        int len = points.length;
        PriorityQueue<Point> heap = new PriorityQueue<>((p1, p2) -> (((p2.x * p2.x) + (p2.y * p2.y)) - ((p1.x * p1.x) + (p1.y * p1.y))));
        for (Point point : points) {
            if (heap.isEmpty() || heap.size() < k) {
                heap.add(point);
            } else {
                heap.add(point);
                heap.poll();
            }
        }
        return new ArrayList<>(heap);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}