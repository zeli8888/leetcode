package exercise;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author : Ze Li
 * @Date : 15/06/2025 12:39
 * @Version : V1.0
 * @Description :
 */
public class RandomPickWithWeight528 {
    public static void main(String[] args) {
        Solution solution = new RandomPickWithWeight528().new Solution(new int[] {4,2});
        for (int i = 0; i < 8; i++) {
            System.out.println(solution.pickIndex());
        }
    }

    class Solution {
        double[] pro;
        Random random = new Random();

        public Solution(int[] w) {
            pro = new double[w.length];
            double sum = Arrays.stream(w).sum();
            pro[0] = w[0]/sum;
            for (int i = 1; i < w.length; i++) {
                pro[i] = w[i]/sum + pro[i-1];
            }
        }

        public int pickIndex() {
            double target = random.nextDouble(1.0);
            int l = 0;
            int r = pro.length-1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (pro[mid] > target) {
                    r = mid - 1;
                }else if (pro[mid] < target) {
                    l = mid + 1;
                }else {
                    return mid;
                }
            }
            return l;
        }
    }
}
