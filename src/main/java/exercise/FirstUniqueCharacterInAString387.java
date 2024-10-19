package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 19/10/2024 19:37
 * @Version : V1.0
 * @Description :
 */
public class FirstUniqueCharacterInAString387{
    public static void main(String[] args) {
        String s = "loveleetcode";
        int result = new FirstUniqueCharacterInAString387().firstUniqChar(s);
        System.out.println(result);
    }
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            characterIntegerHashMap.put(c, characterIntegerHashMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (characterIntegerHashMap.get(s.charAt(i)) == 1){return i;}
        }
        return -1;
    }
}
