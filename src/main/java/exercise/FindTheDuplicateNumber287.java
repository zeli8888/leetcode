package exercise;

/**
 * @Author : Ze Li
 * @Date : 13/06/2025 11:52
 * @Version : V1.0
 * @Description :
 */
public class FindTheDuplicateNumber287 {
//    public int findDuplicate(int[] nums) {
//        int l = 0;
//        int r = nums.length-1;
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            int count = 0;
//            for (int num : nums) {
//                if (num <= mid) {
//                    count++;
//                }
//            }
//            if (count <= mid) l = mid+1;
//            else r = mid-1;
//        }
//        return l;
//    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        int slow2 = nums[0];

        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}
