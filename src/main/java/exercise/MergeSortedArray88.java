package exercise;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 18/10/2024 11:18
 * @Version : V1.0
 * @Description :
 */

// 1,5,9,11
// 2,4,7,10
public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        new MergeSortedArray88().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        } else if (n != 0) {
            int num1Index = m - 1;
            int num2Index = n - 1;
            for (int i = m + n - 1; i >= 0; i--) {
                if (nums2[num2Index] <= nums1[num1Index]) {
                    nums1[i] = nums1[num1Index];
                    num1Index--;
                } else {
                    nums1[i] = nums2[num2Index];
                    num2Index--;
                }
                if (num1Index < 0) {
                    while (num2Index >= 0) {
                        i--;
                        nums1[i] = nums2[num2Index];
                        num2Index--;
                    }
                    return;
                }
                if (num2Index < 0) {
                    while (num1Index >= 0) {
                        i--;
                        nums1[i] = nums1[num1Index];
                        num1Index--;
                    }
                    return;
                }
            }
        }
    }
}