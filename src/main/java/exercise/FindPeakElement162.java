package exercise;

/**
 * @Author : Ze Li
 * @Date : 30/11/2024 15:08
 * @Version : V1.0
 * @Description :
 */
public class FindPeakElement162 {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int length = nums.length;
        int high = length-1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (mid != 0 && nums[mid] < nums[mid-1]){
                high = mid-1;
                continue;
            }
            if (mid != length-1 && nums[mid] < nums[mid+1]){
                low = mid+1;
                continue;
            }
            return mid;
        }
        return 0;
    }
}
