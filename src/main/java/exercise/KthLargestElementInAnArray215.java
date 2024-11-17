package exercise;

/**
 * @Author : Ze Li
 * @Date : 17/11/2024 17:19
 * @Version : V1.0
 * @Description :
 */
public class KthLargestElementInAnArray215 {
    public static void main(String[] args) {
        KthLargestElementInAnArray215 kthLargestElementInAnArray215 = new KthLargestElementInAnArray215();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(kthLargestElementInAnArray215.findKthLargest(nums, k));
    }

//    public int findKthLargest(int[] nums, int k) {
//        int offset = 10000;
//        int[] present = new int[10000 * 2 + 1];
//        for (int n : nums) {
//            present[n + offset]++;
//        }
//
//        int c = 0;
//        for (int i = present.length-1; i >= 0; i--) {
//            if (present[i] > 0) {
//                c += present[i];
//                if (c >= k) return i - offset;
//            }
//        }
//        return -1;
//    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length-1);
    }
    public int findKthLargest(int[] nums, int k, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left+1; i <= right; i++){
            if (nums[i] > pivot){
                j++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[j];
        nums[j] = pivot;
        nums[left] = temp;
        if (j+1 == k){
            return pivot;
        }else if (j+1 < k){
            return findKthLargest(nums, k, j+1, right);
        }else{
            return findKthLargest(nums, k, left, j-1);
        }
    }

}
