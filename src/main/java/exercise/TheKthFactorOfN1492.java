package exercise;

import java.util.ArrayList;

/**
 * @Author : Ze Li
 * @Date : 16/07/2025 10:52
 * @Version : V1.0
 * @Description :
 */
public class TheKthFactorOfN1492 {
    public static void main(String[] args) {
        Solution solution = new TheKthFactorOfN1492().new Solution();
        System.out.println(solution.kthFactor(4, 4));
    }
    class Solution {
        public int kthFactor(int n, int k) {
            int sqrtN = (int) Math.sqrt(n);
            ArrayList<Integer> largerIndex = new ArrayList<>();
            for (int i = 1; i <= sqrtN; i++) {
                int reminder = n % i;
                int divider = n / i;
                if (reminder != 0) continue;
                k--;
                if (k == 0) return i;
                if (n != divider*divider) largerIndex.add(n / i);
            }
            if (largerIndex.size() < k) return -1;
            return largerIndex.get(largerIndex.size()-k);
        }
    }
}
