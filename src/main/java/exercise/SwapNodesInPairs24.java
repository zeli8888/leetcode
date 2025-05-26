package exercise;

/**
 * @Author : Ze Li
 * @Date : 26/05/2025 14:02
 * @Version : V1.0
 * @Description :
 */
public class SwapNodesInPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next.next;
        ListNode ans = head.next;
        ans.next = head;
        head.next = swapPairs(temp);
        return ans;
    }
}
