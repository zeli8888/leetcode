package exercise;

/**
 * @Author : Ze Li
 * @Date : 01/02/2025 14:16
 * @Version : V1.0
 * @Description :
 */
public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int left, int right){
        int temp;
        while (left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
