package exercise;

/**
 * @Author : Ze Li
 * @Date : 26/12/2024 15:05
 * @Version : V1.0
 * @Description :
 */
public class RemoveDuplicatesFromSortedArray26 {
    public int removeDuplicates(int[] nums) {
        int a = nums[0];
        int j = 1;
        for (int num : nums){
            if (num == a){
                continue;
            }else{
                a = num;
                nums[j] = a;
                j++;
            }
        }
        return j;
    }
}
