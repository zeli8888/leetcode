package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 06/11/2024 14:39
 * @Version : V1.0
 * @Description :
 */
public class FindTargetIndicesAfterSortingArray2089 {
    public static void main(String[] args) {
        int[] nums= {33,22,49,7,2,6,13,70,59,19,21,45,98,93,32,23,89,47,17,27,11,22,93,77,52,34,75,96,48,53,44,76,76,7,48,25,68,70,48,32,89,21,12,81,65,36,92,21,94,84,77,43,4,88,78,82,94,20,52,20,16,84,83,100,84,97,49,10,12,94,88,24,1,31,81,95,92,51,36,84,48,34,85,8,3,47,46,18,84,43,42,35,97,60,93,14,92,47,44,72};
        FindTargetIndicesAfterSortingArray2089 findTargetIndicesAfterSortingArray2089 = new FindTargetIndicesAfterSortingArray2089();
        List<Integer> result = findTargetIndicesAfterSortingArray2089.targetIndices(nums, 84);
        System.out.println(result);
    }

    public List<Integer> targetIndicesQuicker(int[] nums, int target) {
        int numSmaller = 0;
        int count = 0;
        for (int n : nums) {
            if (n < target) {
                numSmaller++;
            } else if (n == target) {
                count++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            res.add(i + numSmaller);
        }
        return res;
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        quickSort(nums);
        int left = 0;
        int right = nums.length - 1;
        List<Integer> result = new ArrayList<>();
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                for(int i = left; i < mid ; i++){
                    if (nums[i] == target){
                        result.add(i);
                    }
                }
                result.add(mid);
                left = mid + 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public void quickSort(int[] nums){
        if (nums.length <= 1){
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }
    public void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++){
            if (nums[i] < pivot){
                j++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[j];
        nums[j] = pivot;
        nums[left] = temp;
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }
}
