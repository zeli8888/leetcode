package exercise;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 26/01/2025 11:00
 * @Version : V1.0
 * @Description :
 */
public class InsertInterval57 {
    public static void main(String[] args) {
        InsertInterval57 insertInterval57 = new InsertInterval57();
        System.out.println(Arrays.deepToString(insertInterval57.insert(new int[][]{}, new int[]{4, 8})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int insertStartIndex = 0;
        while(insertStartIndex < intervals.length && newInterval[0] > intervals[insertStartIndex][1]) insertStartIndex++;

        int insertEndIndex = insertStartIndex;
        while(insertEndIndex < intervals.length && newInterval[1] >= intervals[insertEndIndex][0]) insertEndIndex++;

        int[][] result = new int[intervals.length - (insertEndIndex - insertStartIndex) + 1][2];
        int resultIndex = 0;
        while(resultIndex < insertStartIndex) {
            result[resultIndex] = intervals[resultIndex++];
        }

        // overlap with at least one interval in intervals
        if(insertEndIndex > insertStartIndex) {
            newInterval[0] = Math.min(intervals[insertStartIndex][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[insertEndIndex - 1][1], newInterval[1]);
        }

        result[resultIndex++] = newInterval;

        while(resultIndex < result.length) {
            result[resultIndex++] = intervals[insertEndIndex++];
        }

        return result;
    }

//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        if (intervals.length == 0) {return new int[][]{newInterval};}
//        int left = bitSearch(intervals, newInterval[0], 0, intervals.length-1);
//        int right = bitSearch(intervals, newInterval[1], 0, intervals.length-1);
//        ArrayList<int[]> ans = new ArrayList<>();
//        if (left >= intervals.length) left--;
//        if (right >= intervals.length) right--;
//        for (int i = 0; i < left; i++){
//            ans.add(intervals[i]);
//        }
//
//        int[] curInterval = new int[2];
//        if (newInterval[0] <= intervals[left][1]+1){
//            curInterval[0] = Math.min(newInterval[0], intervals[left][0]);
//        }else{
//            ans.add(intervals[left]);
//            curInterval[0] = newInterval[0];
//        }
//        if (newInterval[1] < intervals[right][0]){
//            curInterval[1] = newInterval[1];
//            ans.add(curInterval);
//            ans.add(intervals[right]);
//        }else if (newInterval[1] < intervals[right][1]){
//            curInterval[1] = intervals[right][1];
//            ans.add(curInterval);
//        }else{
//            curInterval[1] = newInterval[1];
//            ans.add(curInterval);
//        }
//
//        for (int i = right+1; i < intervals.length; i++){
//            ans.add(intervals[i]);
//        }
//        return ans.toArray(new int[ans.size()][]);
//    }
//    private int bitSearch(int[][] intervals, int pos, int left, int right){
//        if (left > right) return left;
//        int mid = (left + right) / 2;
//        if (pos < intervals[mid][0]){
//            return bitSearch(intervals, pos, left, mid-1);
//        } else if (pos > intervals[mid][1]) {
//            return bitSearch(intervals, pos, mid+1, right);
//        }
//        return mid;
//    }
}
