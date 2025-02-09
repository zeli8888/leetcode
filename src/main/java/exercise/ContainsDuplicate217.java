package exercise;

import java.util.HashSet;

/**
 * @Author : Ze Li
 * @Date : 09/02/2025 15:57
 * @Version : V1.0
 * @Description :
 */
public class ContainsDuplicate217 {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                ans += 2;
            } else {
                set.add(c);
            }
        }
        if (!set.isEmpty()) {
            ans += 1;
        }
        return ans;
    }
}
