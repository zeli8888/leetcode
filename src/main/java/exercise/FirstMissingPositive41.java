package exercise;

/**
 * @Author : Ze Li
 * @Date : 22/05/2025 15:53
 * @Version : V1.0
 * @Description :
 */
public class FirstMissingPositive41 {
    public static void main(String[] args) {
        FirstMissingPositive41 firstMissingPositive41 = new FirstMissingPositive41();
        System.out.println(firstMissingPositive41.firstMissingPositive(new int[]{1, 2, 0}));
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its correct position if possible
        for (int i = 0; i < n; i++) {
            // while current number is in range [1, n] and not in correct position
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // Swap nums[i] with the element at its target position
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: Find the first position where index + 1 != value
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // This is the smallest missing positive
            }
        }

        // If all numbers from 1 to n are in place, return n + 1
        return n + 1;
    }
}
