package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author : Ze Li
 * @Date : 09/06/2025 11:56
 * @Version : V1.0
 * @Description :
 */
public class SmallestRangeCoveringElementsFromKLists632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] ans = new int[2];
        int curLen = 200000;
        int max = -100000;
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            heap.add(new int[] {val, i, 0});
            max = Math.max(max, val);
        }
        while (true) {
            int[] minValAndIndex = heap.poll();
            if (max - minValAndIndex[0] < curLen) {
                ans[0] = minValAndIndex[0];
                ans[1] = max;
                curLen = max - minValAndIndex[0];
            }
            minValAndIndex[2]++;
            if (minValAndIndex[2] == nums.get(minValAndIndex[1]).size()) return ans;
            minValAndIndex[0] = nums.get(minValAndIndex[1]).get(minValAndIndex[2]);
            max = Math.max(max, minValAndIndex[0]);
            heap.add(minValAndIndex);
        }
    }
}
