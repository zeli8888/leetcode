package exercise;

/**
 * @Author : Ze Li
 * @Date : 24/01/2025 09:41
 * @Version : V1.0
 * @Description :
 */
public class SingleNumberIII260 {
    public int[] singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++){
            num ^= nums[i];
        }

        int index = num & (-num);

        int [] result = new int[2];

        for (int i = 0; i < nums.length; i++){
            if ((nums[i] & index) == 0){
                result[0] ^= nums[i];
            }else{
                result[1] ^= nums[i];
            }
        }

        return result;
    }
}
