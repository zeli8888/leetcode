package exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Ze Li
 * @Date : 01/08/2025 14:10
 * @Version : V1.0
 * @Description :
 */
public class ImplementStackUsingQueues225 {
    class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
