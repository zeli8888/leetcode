package exercise;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author : Ze Li
 * @Date : 09/03/2025 10:31
 * @Version : V1.0
 * @Description :
 */
public class MaximumProfitInJobScheduling1235 {
    public static void main(String[] args) {
        MaximumProfitInJobScheduling1235 maximumProfitInJobScheduling1235 = new MaximumProfitInJobScheduling1235();
        System.out.println(maximumProfitInJobScheduling1235.jobScheduling(
                new int[]{4,3,1,2,4,8,3,3,3,9},
                new int[]{5,6,3,5,9,9,8,5,7,10},
                new int[]{9,9,5,12,10,11,10,4,14,7}));
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));
        int[] dp = new int[startTime.length+1];
        for (int i = 0; i < jobs.length; i++){
            int profitI = jobs[i].profit;
            int noConflictIndex = noConflictIndex(jobs, i);
            dp[i+1] = Math.max(dp[i], dp[noConflictIndex+1] + profitI);
        }
        return dp[startTime.length];
    }

    public int noConflictIndex(Job[] jobs, int curIndex){
        int startTime = jobs[curIndex].startTime;
        int left = 0;
        int right = curIndex;
        int target = -1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            int midEndTime = jobs[mid].endTime;
            if (midEndTime <= startTime){
                target = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return target;

    }

    private class Job{
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}

