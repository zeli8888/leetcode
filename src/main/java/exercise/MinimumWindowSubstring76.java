package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 10/02/2025 11:12
 * @Version : V1.0
 * @Description :
 */
public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        MinimumWindowSubstring76 minimumWindowSubstring76 = new MinimumWindowSubstring76();
        System.out.println(minimumWindowSubstring76.minWindow("bbaac", "aba"));
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        /// UPVOTE !
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();

        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? new String() :
                new String(chS, startIndex, minLen);
    }
//    public String minWindow(String s, String t) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        HashMap<Character, Integer> tMap = new HashMap<>();
//        for (char c : t.toCharArray()){
//            map.put(c, 0);
//            if (!tMap.containsKey(c)){
//                tMap.put(c, 1);
//            }else{
//                tMap.put(c, tMap.get(c)+1);
//            }
//        }
//        int curContainChars = 0;
//        int[] index = new int[]{0,s.length()+1};
//        int i = 0;
//        int j = 0;
//        int minLen = s.length()+1;
//        while (true){
//            while (j < s.length()){
//                char c = s.charAt(j);
//                if (map.containsKey(c)){
//                    int cSaved = map.get(c);
//                    if (cSaved == tMap.get(c)-1){
//                        curContainChars++;
//                    }
//                    map.put(c, cSaved+1);
//                    if (curContainChars == tMap.size()){
//                        j++;
//                        break;
//                    }
//                }
//                j++;
//            }
//            if (curContainChars != tMap.size()){
//                if (index[1]==s.length()+1){
//                    return "";
//                }else{
//                    return s.substring(index[0], index[1]);
//                }
//            }
//            while(i <= j){
//                char c = s.charAt(i);
//                if (map.containsKey(c)){
//                    int cSaved = map.get(c);
//                    map.put(c, cSaved-1);
//                    if (cSaved == tMap.get(c)){
//                        curContainChars--;
//                        if (j-i < index[1]-index[0]){
//                            index[0] = i;
//                            index[1] = j;
//                        }
//                        i++;
//                        break;
//                    }
//                }
//                i++;
//            }
//            if (j == s.length()){
//                if (index[1]==s.length()+1){
//                    return "";
//                }else{
//                    return s.substring(index[0], index[1]);
//                }
//            }
//        }
//    }
}
