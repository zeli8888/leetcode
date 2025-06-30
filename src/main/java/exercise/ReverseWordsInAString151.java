package exercise;

import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 30/06/2025 13:53
 * @Version : V1.0
 * @Description :
 */
public class ReverseWordsInAString151 {
    class Solution {
        public String reverseWords(String s) {
            Stack<String> wordStack = new Stack<>();
            String[] sArray = s.split(" ");
            for(String s2 : sArray) {
                if (!s2.isEmpty()) {
                    wordStack.push(s2);
                }
            }
            StringBuilder ans = new StringBuilder();
            while (!wordStack.isEmpty()) {
                ans.append(wordStack.pop());
                ans.append(" ");
            }
            String string = ans.toString();
            return string.substring(0, string.length()-1);
        }
    }
}
