package exercise;

/**
 * @Author : Ze Li
 * @Date : 02/12/2024 00:02
 * @Version : V1.0
 * @Description :
 */
public class JumpGame55 {

//    ugly solution
//    public boolean canJump(int[] nums) {
//        int pos = 0;
//        int formerPos = 0;
//        while (pos < nums.length-1){
//            if (nums[pos] <= 0){
//                pos = formerPos;
//                nums[pos]--;
//            }
//            formerPos = pos;
//            pos += nums[pos];
//            if (pos < 0){
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean canJump(int[] nums) {
        int maxDist = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i > maxDist) return false;
            maxDist = Math.max(i + nums[i], maxDist);
        }
        return true;
    }

//    public boolean canJump(int[] nums) {
//        int curr = nums.length-1;
//
//        for(int i = nums.length - 2; i >= 0; i--)
//        {
//            if(nums[i] + i >= curr)
//                curr = i;
//        }
//
//        return curr == 0;
//    }
}
