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
        if (nums2.length != 0){
            int i = 0;
            int j = 0;
            Stack<Integer> stack = new Stack<>();
            while (j < m){
                if (nums2[i] < nums1[j]){
                    stack.push(nums2[i]);
                    i++;
                    if (i==n){
                        for(int l=j; l<m; l++){
                            stack.push(nums1[l]);
                        }
                        break;
                    }
                }else{
                    stack.push(nums1[j]);
                    j++;
                    if (j==m){
                        for(int l=i; l<n; l++){
                            stack.push(nums2[l]);
                        }
                        break;
                    }
                }
            }
            for (int k=m+n-1; k>=0; k--){
                nums1[k] = stack.pop();
            }
        }
    }
}
