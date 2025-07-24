package exercise;

/**
 * @Author : Ze Li
 * @Date : 24/07/2025 13:59
 * @Version : V1.0
 * @Description :
 */
public class RemoveLinkedListElements203 {
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode fakeRoot = new ListNode();
            ListNode lastNode = fakeRoot;
            lastNode.next = head;
            ListNode curNode = head;
            while (curNode != null) {
                if (curNode.val == val) {
                    lastNode.next = curNode.next;
                }else {
                    lastNode = curNode;
                }
                curNode = curNode.next;
            }
            return fakeRoot.next;
        }
    }
}
