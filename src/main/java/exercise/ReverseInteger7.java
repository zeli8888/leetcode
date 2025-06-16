package exercise;

/**
 * @Author : Ze Li
 * @Date : 16/06/2025 17:18
 * @Version : V1.0
 * @Description :
 */
public class ReverseInteger7 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int reminder = x % 10;
            x = x / 10;
            if (ans > Integer.MAX_VALUE/10 || ans < Integer.MIN_VALUE/10) return 0;
            ans = ans * 10 + reminder;
        }
        return ans;
    }
}
