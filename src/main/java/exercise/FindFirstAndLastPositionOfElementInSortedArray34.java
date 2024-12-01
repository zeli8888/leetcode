package exercise;

/**
 * @Author : Ze Li
 * @Date : 01/12/2024 19:19
 * @Version : V1.0
 * @Description :
 */
public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] < target){
                low = mid + 1;
                continue;
            }
            if (nums[mid] > target){
                high = mid - 1;
                continue;
            }
            for (low = mid; low >= 0; low--){
                if (nums[low] != target) {
                    break;
                }
            }
            for (high = mid; high <= nums.length - 1; high++){
                if (nums[high] != target){
                    break;
                }
            }
            return new int[] {low+1, high-1};
        }
        return new int[] {-1, -1};
    }
}
