package exercise;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 05/08/2025 15:34
 * @Version : V1.0
 * @Description :
 */
public class NextGreaterElementI496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] nextGreater = new int[10001];
            Stack<Integer> stack = new Stack<>();

            for (int i = nums2.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }
                nextGreater[nums2[i]] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums2[i]);
            }

            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nextGreater[nums1[i]];
            }

            return nums1;
        }
    }
//    class Solution {
//        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
//
//        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//            nextGreaterMap.put(nums2[nums2.length-1], -1);
//            int latest = nums2[nums2.length-1];
//            for (int i = nums2.length-2; i >= 0; i--) {
//                if (latest <= nums2[i]){
//                    while (latest < nums2[i]) {
//                        latest = nextGreaterMap.get(latest);
//                        if (latest == -1) break;
//                    }
//                }
//                nextGreaterMap.put(nums2[i], latest);
//                latest = nums2[i];
//            }
//            int[] ans = new int[nums1.length];
//            for (int i = 0; i < nums1.length; i++) {
//                ans[i] = nextGreaterMap.get(nums1[i]);
//            }
//            return ans;
//        }
//    }
}
