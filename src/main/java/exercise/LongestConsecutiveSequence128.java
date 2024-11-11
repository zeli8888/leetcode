package exercise;

import java.util.HashSet;

/**
 * @Author : Ze Li
 * @Date : 11/11/2024 20:44
 * @Version : V1.0
 * @Description :
 */
public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            integers.add(num);
        }
        int longest = 0;
        for (int num : integers){
            if (!integers.contains(num - 1)){
                int length = 1;
                while (integers.contains(num + length)){
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
