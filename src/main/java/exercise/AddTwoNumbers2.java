package exercise;

/**
 * @Author : Ze Li
 * @Date : 27/05/2025 15:52
 * @Version : V1.0
 * @Description :
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;
        ListNode ans = new ListNode();
        if (l1 == null && l2 != null) {
            ans.val = (l2.val + carry) % 10;
            ans.next = addTwoNumbers(null, l2.next, (l2.val+carry)/10);
            return ans;
        }
        if (l2 == null && l1 != null) {
            ans.val = (l1.val + carry) % 10;
            ans.next = addTwoNumbers(null, l1.next, (l1.val+carry)/10);
            return ans;
        }
        if (l1 == null) {
            ans.val = carry % 10;
            ans.next = addTwoNumbers(null, null, carry/10);
            return ans;
        }
        ans.val = (l1.val + l2.val + carry) % 10;
        ans.next = addTwoNumbers(l1.next, l2.next, (l1.val+l2.val+carry)/10);
        return ans;
    }
}
