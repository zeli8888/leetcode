package exercise;

import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 07/06/2025 11:39
 * @Version : V1.0
 * @Description :
 */
public class TaskScheduler621 {
    public static void main(String[] args) {
        System.out.println(new TaskScheduler621().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 1));
    }
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int chunk = freq[25] - 1;
        int idle = chunk * n;

        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(chunk, freq[i]);
        }

        return idle < 0 ? tasks.length : tasks.length + idle;
    }
}
