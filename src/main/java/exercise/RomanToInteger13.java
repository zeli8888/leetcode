package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 14/06/2025 12:57
 * @Version : V1.0
 * @Description :
 */
public class RomanToInteger13 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        int last = map.get(s.charAt(0));
        for (char c : s.toCharArray()) {
            int val = map.get(c);
            if (last >= val) ans += val;
            else ans -= val;
            last = val;
        }
        return ans;
    }
}
