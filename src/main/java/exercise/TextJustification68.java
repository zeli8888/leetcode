package exercise;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 05/07/2025 13:31
 * @Version : V1.0
 * @Description :
 */
public class TextJustification68 {
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            ArrayList<String> ans = new ArrayList<>();
            Queue<String> curWords = new LinkedList<>();
            int curWidth = 0;
            for (String word : words) {
                if (curWidth + word.length() + curWords.size() > maxWidth) {
                    ans.add(justifyStringLeft(curWords, maxWidth, curWidth));
                    curWidth = word.length();
                    curWords = new LinkedList<>(Collections.singleton(word));
                }else {
                    curWidth += word.length();
                    curWords.offer(word);
                }
            }
            ans.add(justifyStringRight(curWords, maxWidth));
            return ans;
        }

        public String justifyStringLeft(Queue<String> curWords, int maxWidth, int curWidth) {
            if (curWords.size() == 1 ) return justifyStringRight(curWords, maxWidth);
            int numSpace = maxWidth - curWidth;
            int numSpaceEach = numSpace / (curWords.size()-1);
            int numSpaceEachExtra = numSpace % (curWords.size()-1);
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String word = curWords.poll();
                stringBuilder.append(word);
                if (!curWords.isEmpty()) stringBuilder.append(" ".repeat(numSpaceEach+(numSpaceEachExtra>0?1:0)));
                else break;
                numSpaceEachExtra--;
            }
            return stringBuilder.toString();
        }

        public String justifyStringRight(Queue<String> curWords, int maxWidth) {
            StringBuilder stringBuilder = new StringBuilder();
            while (!curWords.isEmpty()) {
                String word = curWords.poll();
                stringBuilder.append(word);
                if (stringBuilder.length() < maxWidth) stringBuilder.append(" ");
            }
            return stringBuilder.toString()+" ".repeat(maxWidth-stringBuilder.length());
        }
    }
}
