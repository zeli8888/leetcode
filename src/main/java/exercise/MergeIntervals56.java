package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author : Ze Li
 * @Date : 26/11/2024 17:48
 * @Version : V1.0
 * @Description :
 */
public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            if (currentInterval[1] >= intervals[i][0]) {
                currentInterval[1] = Math.max(intervals[i][1], currentInterval[1]);
            } else {
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        result.add(currentInterval);
        return result.toArray(new int[result.size()][]);
    }

//    public int[][] merge(int[][] intervals) {
//        int max = 0;
//        for (int i = 0; i < intervals.length; i++) {
//            max = Math.max(intervals[i][0], max);
//        }
//        int[] mp = new int[max + 1];
//        for (int i = 0; i < intervals.length; i++) {
//            int start = intervals[i][0];
//            int end = intervals[i][1];
//            //to handle cases [0,0]
//            mp[start] = Math.max(end+1, mp[start]);
//        }
//        int r = 0;
//        int initialStart = -1;
//        int have = -1;
//        for (int i = 0; i < mp.length; i++) {
//            if (mp[i] != 0) {
//                if (initialStart == -1)
//                    initialStart = i;
//                //to handle cases [0,0]
//                have = Math.max(mp[i]-1, have);
//            }
//            if (have == i) {
//                intervals[r++] = new int[] { initialStart, have };
//                initialStart = -1;
//                have = -1;
//            }
//        }
//        if (initialStart != -1) {
//            intervals[r++] = new int[] { initialStart, have };
//        }
//        if (intervals.length == r) {
//            return intervals;
//        }
//        int[][] res = new int[r][];
//        for (int i = 0; i < r; i++) {
//            res[i] = intervals[i];
//        }
//        return res;
//    }
}
