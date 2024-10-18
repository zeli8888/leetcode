/**
 * @Author : Ze Li
 * @Date : 18/10/2024 09:26
 * @Version : V1.0
 * @Description :
 */

import java.util.Collection;
import java.util.Stack;


public class BaseballGame682 {
    public static void main(String[] args) {

    }
    public int calPoints(String[] operations) {
        Stack<Integer> record = new Stack<>();
        for (String operation : operations) {
            if (operation.equals("+")) {
                int num1 = record.get(record.size()-2);
                int num2 = record.peek();
                record.push(num1+num2);
            }
            else if (operation.equals("D")) {
                int num = record.peek() * 2;
                record.push(num);
            }
            else if (operation.equals("C")) {
                record.pop();
            }
            else {
                record.push(Integer.parseInt(operation));
            }
        }

        int sum = 0;
        for (int num : record) {
            sum += num;
        }
        return sum;
    }
}

