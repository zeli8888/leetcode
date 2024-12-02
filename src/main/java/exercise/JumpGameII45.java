package exercise;

/**
 * @Author : Ze Li
 * @Date : 02/12/2024 00:35
 * @Version : V1.0
 * @Description :
 */
public class JumpGameII45 {
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,1,4};
        JumpGameII45 jumpGameII45 = new JumpGameII45();
        System.out.println(jumpGameII45.jump(nums));
    }
    // ugly solution
//    public int jump(int[] nums) {
//        int[] steps = new int[nums.length];
//        for (int i = 1; i < nums.length; i++){
//            steps[i] = Integer.MAX_VALUE;
//            for (int j = i-1; j >= 0; j--){
//                if (nums[j] + j >= i){
//                    steps[i] = Math.min(steps[i], steps[j]+1);
//                }
//            }
//        }
//        return steps[nums.length-1];
//    }

    public int jump(int[] nums){
        int maxPos = 0;
        int currentPos = 0;
        int result = 0;
        for (int i = 0; i<nums.length-1; i++){
            maxPos = Math.max(i+nums[i], maxPos);
            if (i == currentPos){
                result++;
                currentPos = maxPos;
            }
        }
        return result;
    }
}
