package exercise;

import java.util.Objects;

/**
 * @Author : Ze Li
 * @Date : 13/02/2025 11:20
 * @Version : V1.0
 * @Description :
 */
public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        LongestCommonPrefix14 longestCommonPrefix14 = new LongestCommonPrefix14();
        System.out.println(longestCommonPrefix14.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        String ans = "";
        while (true){
            if (index >= strs[0].length()){return ans;}
            char curChar = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++){
                String str = strs[i];
                if (index == str.length()){return ans;}
                char c = str.charAt(index);
                if (c != curChar){
                    return ans;
                }
            }
            ans += curChar;
            index++;
        }
    }
}
