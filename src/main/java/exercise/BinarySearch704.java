package exercise;

/**
 * @Author : Ze Li
 * @Date : 17/01/2025 13:50
 * @Version : V1.0
 * @Description :
 */
public class BinarySearch704 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    private int binarySearch(int[] nums, int target, int left, int right){
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] > target){
            return binarySearch(nums, target, left, mid-1);
        }else if (nums[mid] < target){
            return binarySearch(nums, target, mid+1, right);
        }else{
            return mid;
        }
    }
}
