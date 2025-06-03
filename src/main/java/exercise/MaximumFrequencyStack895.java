package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 03/06/2025 17:04
 * @Version : V1.0
 * @Description :
 */
public class MaximumFrequencyStack895 {
    class FreqStack {
        private HashMap<Integer, Integer> count;
        private ArrayList<Stack<Integer>> stacks;

        public FreqStack() {
            count = new HashMap<>();
            stacks = new ArrayList<>();
            stacks.add(new Stack<>());
        }

        public void push(int val) {
            int valCount = count.getOrDefault(val, 0) + 1;
            if (valCount == stacks.size()) {
                stacks.add(new Stack<>());
            }
            stacks.get(valCount).push(val);
            count.put(val, valCount);
        }

        public int pop() {
            Stack<Integer> topStack = stacks.get(stacks.size() - 1);
            Integer val = topStack.pop();
            if (topStack.isEmpty()) {
                stacks.remove(stacks.size()-1);
            }
            count.put(val, count.get(val)-1);
            return val;
        }
    }
}
