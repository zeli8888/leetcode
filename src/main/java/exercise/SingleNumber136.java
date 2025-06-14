package exercise;

/**
 * @Author : Ze Li
 * @Date : 14/06/2025 12:51
 * @Version : V1.0
 * @Description :
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }
}
