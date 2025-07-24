package exercise;

import java.util.HashSet;

/**
 * @Author : Ze Li
 * @Date : 24/07/2025 14:09
 * @Version : V1.0
 * @Description :
 */
public class IntersectionOfTwoLinkedLists160 {
    class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            HashSet<ListNode> listNodes = new HashSet<>();
            while (headA != null) {
                listNodes.add(headA);
                headA = headA.next;
            }
            while (headB != null) {
                if (listNodes.contains(headB)) return headB;
                headB = headB.next;
            }
            return null;
        }
    }
}
