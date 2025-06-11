package exercise;

import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 11/06/2025 16:13
 * @Version : V1.0
 * @Description :
 */
public class DecodeWays91 {
    public static void main(String[] args) {
        DecodeWays91 decodeWays91 = new DecodeWays91();
        System.out.println(decodeWays91.numDecodings("20026"));
    }

    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i=2;i<=n;i++){
            int one = Character.getNumericValue(s.charAt(i-1));
            int two = Integer.parseInt(s.substring(i-2, i));

            if(1 <= one && one <= 9)
                dp[i] += dp[i-1];

            if(10<=two && two<=26)
                dp[i] += dp[i-2];

        }
        return dp[n];
    }

//    public int numDecodings(String s) {
//        if (s.charAt(0) == '0') return 0;
//        if (s.length() == 1) return 1;
//        int[] dp = new int[s.length()];
//        if (s.charAt(1) == '0') {
//            if (isValid(s, 0, 1)) dp[1] = 1;
//            else return 0;
//        }else {
//            if (isValid(s, 0, 1)) dp[1] = 2;
//            else dp[1] = 1;
//        }
//        dp[0] = 1;
//
//        for (int i = 2; i < s.length(); i++) {
//            if (s.charAt(i) == '0') {
//                if (!isValid(s, i-1, i)) return 0;
//                else dp[i] = dp[i-2];
//            }else {
//                if (isValid(s, i-1, i)) dp[i] = dp[i-2] + dp[i-1];
//                else dp[i] = dp[i-1];
//            }
//        }
//
//        return dp[s.length()-1];
//    }
//
//    public boolean isValid(String s, int i, int j) {
//        if (s.charAt(i) == '0') return false;
//        return Integer.parseInt(s.charAt(i) + "" + s.charAt(j)) <= 26;
//    }
}
