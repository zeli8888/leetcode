package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 11/01/2025 14:04
 * @Version : V1.0
 * @Description :
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 longestSubstringWithoutRepeatingCharacters3 = new LongestSubstringWithoutRepeatingCharacters3();
        String s = "abcabcbb";
        System.out.println(longestSubstringWithoutRepeatingCharacters3.lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int i = 0;
        int ans = 0;
        for (int j = 0; j < s.length(); j++){
            char l = s.charAt(j);
            while(charMap.getOrDefault(l, 0) != 0){
                charMap.put(s.charAt(i), 0);
                i++;
            }
            charMap.put(l, 1);
            ans = Math.max(ans, j-i+1);
        }
        return ans;
    }
}
