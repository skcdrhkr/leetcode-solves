import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {
    static class MedianFinder {

        PriorityQueue<Integer> minH;
        PriorityQueue<Integer> mxH;

        public MedianFinder() {
            minH = new PriorityQueue<Integer>();
            mxH = new PriorityQueue<Integer>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            if (mxH.isEmpty()) {
                mxH.add(num);
                return;
            }

            int prev;
            if (num <= mxH.peek()) {
                mxH.add(num);
                if ((mxH.size() - minH.size()) >= 2)
                    minH.add(mxH.poll());
            } else if (minH.isEmpty() || num >= minH.peek()) {
                minH.add(num);
                if ((minH.size() - mxH.size()) >= 1)
                    mxH.add(minH.poll());
            } else {
                if (mxH.size() == minH.size())
                    mxH.add(num);
                else
                    minH.add(num);
            }
        }

        public double findMedian() {
            if (mxH.size() == minH.size()) {
                return (double) (mxH.peek() + minH.peek()) / 2;
            }
            return (double) mxH.peek();
        }
    }
}
