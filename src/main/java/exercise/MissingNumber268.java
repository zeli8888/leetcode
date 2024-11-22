package exercise;

/**
 * @Author : Ze Li
 * @Date : 18/11/2024 09:15
 * @Version : V1.0
 * @Description :
 */
public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        int sum = nums.length*(nums.length+1)/2;
        for (int num:nums){
            sum -= num;
        }
        return sum;
    }
}
