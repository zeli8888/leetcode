package exercise;

import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 20/06/2025 19:15
 * @Version : V1.0
 * @Description :
 */
public class ReversePairs493 {
    int ans = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return ans;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + (r-l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);

        int[] l_nums = Arrays.copyOfRange(nums, l, mid+1);
        int[] r_nums = Arrays.copyOfRange(nums, mid+1, r+1);
        int j = 0;
        for (int i = 0; i < l_nums.length; i++) {
            while (j < r_nums.length && (long)l_nums[i] > 2 * (long)r_nums[j]) j++;
            ans += j;
        }

        int m = 0, n = 0;
        for (int i = l; i <= r; i++) {
            if (l_nums[m] < r_nums[n]) {
                nums[i] = l_nums[m];
                m++;
                if (m == l_nums.length) {
                    while (n < r_nums.length) {
                        i++;
                        nums[i] = r_nums[n];
                        n++;
                    }
                    return;
                }
            } else {
                nums[i] = r_nums[n];
                n++;
                if (n == r_nums.length) {
                    while (m < l_nums.length) {
                        i++;
                        nums[i] = l_nums[m];
                        m++;
                    }
                    return;
                }
            }
        }
    }
}
