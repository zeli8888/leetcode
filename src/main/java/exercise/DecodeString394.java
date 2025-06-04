package exercise;

import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 04/06/2025 12:56
 * @Version : V1.0
 * @Description :
 */
public class DecodeString394 {
    public static void main(String[] args) {
        System.out.println(new DecodeString394().decodeString("3[a2[c]]"));
    }
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String ans = "";
        int curCount = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curCount = curCount * 10 + (c-'0');
            } else if (Character.isLetter(c)) {
                ans += c;
            }
            else if (c == '[') {
                countStack.push(curCount);
                curCount = 0;
                stringStack.push(ans);
                ans = "";
            } else if (c == ']') {
                int count = countStack.pop();
                String curString = ans;
                ans = stringStack.pop();
                while (count-- > 0) {
                    ans += curString;
                }

            }
        }
        return ans;
    }
}
