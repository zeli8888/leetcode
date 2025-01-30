package exercise;

/**
 * @Author : Ze Li
 * @Date : 30/01/2025 16:51
 * @Version : V1.0
 * @Description :
 */
public class SortColors75 {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int left, int right){
        if (left >= right) return;
        int pivot = nums[left];
        int i = left+1;
        int j = left;
        while (i <= right){
            if (nums[i] < pivot){
                int mid = nums[i];
                nums[i] = nums[j];
                nums[j] = mid;
                j++
            }
        }
        nums[left] = nums[j]
    }
}
