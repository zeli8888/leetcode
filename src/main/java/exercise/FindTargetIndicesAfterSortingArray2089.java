package exercise;

/**
 * @Author : Ze Li
 * @Date : 06/11/2024 14:39
 * @Version : V1.0
 * @Description :
 */
public class FindTargetIndicesAfterSortingArray2089 {
    public void quickSort(int[] nums){
        if (nums.length <= 1){
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }
    public void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++){
            if (nums[i] < pivot){
                j++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[j];
        nums[j] = pivot;
        nums[left] = temp;
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }
}
