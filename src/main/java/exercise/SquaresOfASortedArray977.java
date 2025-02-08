package exercise;

/**
 * @Author : Ze Li
 * @Date : 06/02/2025 14:14
 * @Version : V1.0
 * @Description :
 */
public class SquaresOfASortedArray977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }

//    public int[] sortedSquares(int[] nums) {
//        int signChangeIndex = search(nums, 0, nums.length-1);
//        if(nums[signChangeIndex]<0){signChangeIndex++;}
//        int left = signChangeIndex-1;
//        int right = signChangeIndex;
//        int[] ans = new int[nums.length];
//        int i = 0;
//        while(left >= 0 && right < nums.length){
//            int numLeft = nums[left]*nums[left];
//            int numRight = nums[right]*nums[right];
//            if(numLeft < numRight){
//                ans[i] = numLeft;
//                left--;
//            }else{
//                ans[i] = numRight;
//                right++;
//            }
//            i++;
//        }
//        while(left >= 0){
//            ans[i] = nums[left]*nums[left];
//            left--;
//            i++;
//        }
//        while(right < nums.length){
//            ans[i] = nums[right]*nums[right];
//            right++;
//            i++;
//        }
//        return ans;
//    }
//
//    private int search(int[] nums, int left, int right) {
//        if (left >= right) {
//            return left;
//        }
//        int mid = (left + right) / 2;
//        if (nums[mid] < 0) {
//            return search(nums, mid + 1, right);
//        } else if (nums[mid] == 0) {
//            return mid;
//        } else {
//            return search(nums, left, right - 1);
//        }
//    }
}
