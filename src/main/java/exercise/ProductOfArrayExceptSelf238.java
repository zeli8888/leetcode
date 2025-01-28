package exercise;

/**
 * @Author : Ze Li
 * @Date : 28/01/2025 09:03
 * @Version : V1.0
 * @Description :
 */
public class ProductOfArrayExceptSelf238 {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf238 productOfArrayExceptSelf238 = new ProductOfArrayExceptSelf238();
        productOfArrayExceptSelf238.productExceptSelf(new int[]{1,2,3,4});
    }
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for (int i = nums.length-2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        for (int i = 0; i < nums.length; i++){
            nums[i] = suffix[i] * prefix[i];
        }
        return nums;
    }
}
