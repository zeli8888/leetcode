package exercise;

/**
 * @Author : Ze Li
 * @Date : 26/12/2024 16:54
 * @Version : V1.0
 * @Description :
 */
public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        while (j < nums.length){
            nums[j] = 0;
            j++;
        }
    }
}
