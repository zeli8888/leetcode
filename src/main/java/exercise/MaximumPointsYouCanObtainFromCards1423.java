package exercise;

import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 19/06/2025 13:47
 * @Version : V1.0
 * @Description :
 */
public class MaximumPointsYouCanObtainFromCards1423 {
    public static int maxScore(int[] cardPoints, int k) {
        int lsum =0;
        int rsum =0;
        int maxSum =0;

        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];

        }
        maxSum = lsum;
        int rindex = cardPoints.length -1;
        for(int i=k-1;i>=0;i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[rindex];
            rindex--;
            maxSum = Math.max(maxSum,rsum+lsum);
        }
        return maxSum;
    }
//    public int maxScore(int[] cardPoints, int k) {
//        if (k == cardPoints.length) return Arrays.stream(cardPoints).sum();
//        int curSum = 0;
//        for (int i = 0; i < cardPoints.length - k; i++) {
//            curSum += cardPoints[i];
//        }
//        int ans = -curSum;
//        for (int i = 1, j = cardPoints.length - k; i <=k; i++, j++ ){
//            curSum -= cardPoints[i-1];
//            curSum += cardPoints[j];
//            ans = Math.max(ans, -curSum);
//        }
//        return Arrays.stream(cardPoints).sum() + ans;
//    }
}
