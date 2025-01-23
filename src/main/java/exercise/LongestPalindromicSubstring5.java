package exercise;

/**
 * @Author : Ze Li
 * @Date : 23/01/2025 11:11
 * @Version : V1.0
 * @Description :
 */
public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        int[] ans = new int[2];
        int maxSubLen = 1;
        for (int i = 0; i < s.length()-1; i++){
            for (int j = i+1; j < s.length(); j++){
                dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j] && maxSubLen < j-i) {
                    maxSubLen = j-i+1;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return s.substring(ans[0], ans[1]);
    }
}
