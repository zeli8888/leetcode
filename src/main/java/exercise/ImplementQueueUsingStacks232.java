package exercise;

import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 29/05/2025 16:42
 * @Version : V1.0
 * @Description :
 */
public class ImplementQueueUsingStacks232 {
    public static void main(String[] args) {
        MyQueue myQueue = new ImplementQueueUsingStacks232().new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
    class MyQueue {
        private Stack<Integer> input;
        private Stack<Integer> output;

        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            peek();
            return output.pop();
        }

        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}
