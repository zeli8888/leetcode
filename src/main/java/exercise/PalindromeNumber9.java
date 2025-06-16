package exercise;

/**
 * @Author : Ze Li
 * @Date : 16/06/2025 17:38
 * @Version : V1.0
 * @Description :
 */
public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int reverse = 0;
        int copyX = x;
        while (copyX != 0) {
            int reminder = copyX % 10;
            copyX = copyX / 10;
            if (reverse > Integer.MAX_VALUE/10) return false;
            reverse = reminder + reverse * 10;
        }
        return reverse == x;
    }
}
