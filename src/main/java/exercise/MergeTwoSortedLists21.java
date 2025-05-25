package exercise;

/**
 * @Author : Ze Li
 * @Date : 25/05/2025 17:13
 * @Version : V1.0
 * @Description :
 */
public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode root = ans;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ans.next = list1;
                list1 = list1.next;
            }else {
                ans.next = list2;
                list2 = list2.next;
            }
            ans = ans.next;
        }
        while (list1 != null) {
            ans.next = list1;
            list1 = list1.next;
            ans = ans.next;
        }
        while (list2 != null) {
            ans.next = list2;
            list2 = list2.next;
            ans = ans.next;
        }
        return root.next;
    }
}
