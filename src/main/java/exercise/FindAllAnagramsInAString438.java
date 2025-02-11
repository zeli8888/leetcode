package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 11/02/2025 19:38
 * @Version : V1.0
 * @Description :
 */
public class FindAllAnagramsInAString438 {
    public static void main(String[] args) {
        FindAllAnagramsInAString438 findAllAnagramsInAString438 = new FindAllAnagramsInAString438();
        findAllAnagramsInAString438.findAnagrams("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return List.of();
        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];
        List<Integer> res = new ArrayList<>();

        // Build initial window.
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pFreq, windowFreq)) res.add(0);

        // Start 1 ahead of initial window's end, checking for equality
        // between each new window and the frequency array for p.
        for (int windowEnd = p.length(); windowEnd < s.length(); windowEnd++) {
            int windowStart = windowEnd - p.length() + 1;
            windowFreq[s.charAt(windowStart - 1) - 'a']--;
            windowFreq[s.charAt(windowEnd) - 'a']++;
            if (Arrays.equals(pFreq, windowFreq)) res.add(windowStart);
        }
        return res;
    }

//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> ans = new ArrayList<>();
//        int count = p.length();
//        int[] map = new int[128];
//        for (char c : p.toCharArray()){
//            map[c]++;
//        }
//        for(int i = s.length()-1; i >= count-1; i--){
//            helper(s, map, ans, count, i, count);
//        }
//        return ans;
//    }
//    private void helper(String s, int[] map, List<Integer> ans, int count, int index, int pLen){
//        if (index < 0) {
//            return;
//        }
//
//        char c = s.charAt(index);
//        if (map[c] > 0){
//            map[c]--;
//            count--;
//            if (count == 0) {
//                ans.add(index);
//            }else{
//                helper(s, map, ans, count, --index, pLen);
//            }
//            map[c]++;
//        }
//    }
}
