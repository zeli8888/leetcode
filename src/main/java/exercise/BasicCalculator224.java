package exercise;

import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 30/05/2025 21:08
 * @Version : V1.0
 * @Description :
 */
public class BasicCalculator224 {
    public int calculate(String s) {
        int ans = 0;
        int curNum = 0;
        int curSig = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curNum = curNum*10 + (int) (c - '0');
            } else if (c == '+') {
                ans += curSig * curNum;
                curSig = 1;
                curNum = 0;
            } else if (c == '-') {
                ans += curSig * curNum;
                curSig = -1;
                curNum = 0;
            } else if (c == '(') {
                stack.push(ans);
                stack.push(curSig);
                curSig = 1;
                curNum = 0;
                ans = 0;
            } else if (c == ')') {
                ans = (ans+curNum*curSig)*stack.pop() + stack.pop();
                curSig = 1;
                curNum = 0;
            }
        }
        ans += curSig * curNum;
        return ans;
    }
}
