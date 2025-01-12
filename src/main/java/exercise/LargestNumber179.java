package exercise;

/**
 * @Author : Ze Li
 * @Date : 12/01/2025 10:46
 * @Version : V1.0
 * @Description :
 */
public class LargestNumber179 {
    public String largestNumber(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        String ans = "";
        boolean zeroStart = true;
        for (int num : nums){
            if (zeroStart && num == 0) continue;
            zeroStart = false;
            ans += num;
        }
        return zeroStart? "0" : ans;
    }

    public void quickSort(int[] nums, int left, int right){
        if (left >= right) return;
        int pivot = nums[left];
        int j = left;
        for (int i = left+1; i <= right; i++){
            if (larger(nums[i], pivot)){
                j++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[j];
        nums[left] = temp;
        nums[j] = pivot;
        quickSort(nums, left, j-1);
        quickSort(nums, j+1, right);
    }

    public boolean larger(int a, int b){
        String aString = String.valueOf(a) + String.valueOf(b);
        String bString = String.valueOf(b) + String.valueOf(a);
        for (int i = 0; i < aString.length(); i++){
            if (aString.charAt(i) == bString.charAt(i)) continue;
            return aString.charAt(i) > bString.charAt(i);
        }
        return false;
    }
}
