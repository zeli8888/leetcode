package exercise;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author : Ze Li
 * @Date : 04/02/2025 21:19
 * @Version : V1.0
 * @Description :
 */
public class SlidingWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[nums.length-k+1];
        int ansIndex = 0;
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            while(!deque.isEmpty() && deque.getLast() < num){
                deque.pollLast();
            }
            deque.addLast(num);

            if (i >= k && deque.getFirst() == nums[i-k]){
                deque.pollFirst();
            }
            if (i >= k-1){
                ans[ansIndex] = deque.getFirst();
                ansIndex++;
            }
        }
        return ans;
    }
}
