package exercise;

import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 23/05/2025 14:55
 * @Version : V1.0
 * @Description :
 */
public class NextPermutation31 {
    public static void main(String[] args) {
        NextPermutation31 nextPermutation31 = new NextPermutation31();
        int[] ans = new int[]{1,2,3};
        nextPermutation31.nextPermutation(ans);
        System.out.println(Arrays.toString(ans));
    }
    public void nextPermutation(int[] nums) {
        int stopPoint = -1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                stopPoint = i;
                break;
            }
        }
        if (stopPoint != -1){
            for (int i = nums.length-1; i >= 0; i--) {
                if (nums[i] > nums[stopPoint]) {
                    int temp = nums[stopPoint];
                    nums[stopPoint++] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }else {
            stopPoint++;
        }
        for (int i = nums.length-1; i > stopPoint; i--) {
            int temp = nums[stopPoint];
            nums[stopPoint++] = nums[i];
            nums[i] = temp;
        }
    }
}
