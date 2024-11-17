package exercise;

/**
 * @Author : Ze Li
 * @Date : 17/11/2024 14:51
 * @Version : V1.0
 * @Description :
 */
public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int mx=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum +=nums[i];
            mx=Math.max(mx,sum);
            if(sum<0) sum = 0;
        }
        return mx;
    }
}
