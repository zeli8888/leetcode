package exercise;

/**
 * @Author : Ze Li
 * @Date : 25/06/2025 11:14
 * @Version : V1.0
 * @Description :
 */
public class ValidPalindromeII680 {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length()-1, false);
    }

    public boolean validPalindrome(String s, int l, int r, boolean tolerate) {
        if (l >= r) return true;
        if (s.charAt(l) == s.charAt(r)) return validPalindrome(s, l+1, r-1, tolerate);
        if (tolerate) return false;
        return validPalindrome(s, l+1, r, true) || validPalindrome(s, l, r-1, true);
    }
}
