package exercise;

/**
 * @Author : Ze Li
 * @Date : 06/11/2024 21:41
 * @Version : V1.0
 * @Description :
 */
public class KthMissingPositiveNumber1539 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        KthMissingPositiveNumber1539 kthMissingPositiveNumber1539 = new KthMissingPositiveNumber1539();
        int result = kthMissingPositiveNumber1539.findKthPositive(arr, k);
        System.out.println(result);
    }
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;
    }
}
