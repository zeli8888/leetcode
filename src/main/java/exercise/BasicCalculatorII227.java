package exercise;

import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 05/06/2025 16:06
 * @Version : V1.0
 * @Description :
 */
public class BasicCalculatorII227 {
    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII227().calculate("14/3*2"));
    }
    public int calculate(String s) {
        int curNum = 0;
        char lastOp = '+';
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                curNum = curNum * 10 + (c - '0');
            } else {
                if (lastOp == '+') {
                    stack.push(curNum);
                } else if (lastOp == '-') {
                    stack.push(-curNum);
                } else if (lastOp == '*') {
                    stack.push(stack.pop() * curNum);
                } else if (lastOp == '/') {
                    stack.push(stack.pop() / curNum);
                }
                curNum = 0;
                lastOp = c;
            }
        }

        if (lastOp == '-') {
            curNum *= -1;
        } else if (lastOp == '*') {
            curNum *= stack.pop();
        } else if (lastOp == '/') {
            curNum = stack.pop() / curNum;
        }
        while (!stack.isEmpty()) {
            curNum += stack.pop();
        }
        return curNum;
    }
}
