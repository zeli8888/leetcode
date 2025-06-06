package exercise;

import java.util.PriorityQueue;

/**
 * @Author : Ze Li
 * @Date : 06/06/2025 00:59
 * @Version : V1.0
 * @Description :
 */
public class FindMedianFromDataStream295 {
    class MedianFinder {
        PriorityQueue<Integer> small;
        PriorityQueue<Integer> large;
        boolean even;

        public MedianFinder() {
            small = new PriorityQueue<Integer>((a, b) -> (b - a));
            large = new PriorityQueue<Integer>();
            even = true;
        }

        public void addNum(int num) {
            if (even) {
                small.add(num);
                large.add(small.poll());
            } else {
                large.add(num);
                small.add(large.poll());
            }
            even = !even;
        }

        public double findMedian() {
            if (even) {
                return (large.peek() + small.peek()) / 2.0;
            }else {
                return (double) large.peek();
            }
        }
    }
}
