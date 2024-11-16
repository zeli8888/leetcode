package exercise;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author : Ze Li
 * @Date : 16/11/2024 21:00
 * @Version : V1.0
 * @Description :
 */
public class LongestNiceSubstring1763 {
    public String longestNiceSubstring(String s) {
        int[] index = longestNiceSubstring(s, 0, s.length());
        return s.substring(index[0], index[1]);
    }
    public int[] longestNiceSubstring(String s, int left, int right) {
        HashSet<Character> charSet = new HashSet<>();
        for(int i = left; i < right; i++){
            charSet.add(s.charAt(i));
        }
        for(int i = left; i < right; i++){
            if(charSet.contains(Character.toLowerCase(s.charAt(i))) && charSet.contains(Character.toUpperCase(s.charAt(i)))){
                continue;
            }
            int[] leftSide = longestNiceSubstring(s, left, i);
            int[] rightSide = longestNiceSubstring(s, i+1, right);
            return leftSide[1]-leftSide[0] >= rightSide[1]-rightSide[0] ? leftSide : rightSide;
        }
        return new int[]{left, right};
    }
}
