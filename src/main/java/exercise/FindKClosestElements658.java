package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 08/06/2025 12:05
 * @Version : V1.0
 * @Description :
 */
public class FindKClosestElements658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length-1;
        while (r - l + 1 > k) {
            if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                l++;
            }else r--;
        }
        ArrayList<Integer> ans = new ArrayList<>(k);
        while(l <= r) {
            ans.add(arr[l]);
            l++;
        }
        return ans;
    }
}
