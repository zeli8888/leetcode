package exercise;

/**
 * @Author : Ze Li
 * @Date : 23/07/2025 10:31
 * @Version : V1.0
 * @Description :
 */
public class ConvertBinaryNumberInALinkedListToInteger90 {
    class Solution {
        public int getDecimalValue(ListNode head) {
            int ans = 0;
            while (head != null) {
                ans = ans * 2 + head.val;
                head = head.next;
            }
            return ans;
        }
    }
}
