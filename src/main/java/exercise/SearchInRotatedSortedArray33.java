package exercise;

/**
 * @Author : Ze Li
 * @Date : 07/03/2025 16:26
 * @Version : V1.0
 * @Description :
 */
public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
        SearchInRotatedSortedArray33 searchInRotatedSortedArray33 = new SearchInRotatedSortedArray33();
        System.out.println(searchInRotatedSortedArray33.search(new int[]{2,3,4,5,1}, 1));
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
