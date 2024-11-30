package exercise;

/**
 * @Author : Ze Li
 * @Date : 29/11/2024 17:16
 * @Version : V1.0
 * @Description :
 */
public class SearchInsertPosition35 {
    public static void main(String[] args) {
        int[] array = {1,3,5,6};
        SearchInsertPosition35 searchInsertPosition35 = new SearchInsertPosition35();
        Integer result = searchInsertPosition35.searchInsert(array, 7);
        System.out.println(result);
    }
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                low = mid + 1;
                continue;
            }
            if(nums[mid] > target){
                high = mid - 1;
            }
        }
        return low;
    }
}
