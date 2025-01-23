package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 23/01/2025 10:59
 * @Version : V1.0
 * @Description :
 */
public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c, 0);
            }
            map.put(c, map.get(c)+1);
        }
        for (char c : t.toCharArray()){
            if (!map.containsKey(c)) return false;
            if (map.get(c) == 0) return false;
            map.put(c, map.get(c)-1);
        }
        return true;
    }
}
