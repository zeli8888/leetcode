package exercise;

import java.util.HashSet;

/**
 * @Author : Ze Li
 * @Date : 11/07/2025 22:40
 * @Version : V1.0
 * @Description :
 */
public class HappyNumber202 {
    class Solution {
        HashSet<Integer> track = new HashSet<>();
        public boolean isHappy(int n) {
            int sum = 0;
            while (n > 0) {
                sum += (int) Math.pow(n%10,2);
                n = n / 10;
            }
            if (sum == 1) return true;
            if (track.contains(sum)) return false;
            track.add(sum);
            return isHappy(sum);
        }
    }
}
