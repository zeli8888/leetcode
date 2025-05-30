package exercise;

import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 30/05/2025 20:08
 * @Version : V1.0
 * @Description :
 */
public class EvaluateReversePolishNotation150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> integers = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                integers.push(integers.pop() + integers.pop());
            } else if (token.equals("-")) {
                int operand = integers.pop();
                integers.push(integers.pop() - operand);
            } else if (token.equals("*")) {
                integers.push(integers.pop() * integers.pop());
            } else if (token.equals("/")) {
                int operand = integers.pop();
                integers.push(integers.pop() / operand);
            } else {
                integers.push(Integer.valueOf(token));
            }
        }
        return integers.pop();
    }
}
