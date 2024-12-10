package exercise;

/**
 * @Author : Ze Li
 * @Date : 10/12/2024 01:02
 * @Version : V1.0
 * @Description :
 */
public class ClimbingStairs70 {
    public int climbStairs(int n) {
        int formerSteps = 1;
        int formerFormerSteps = 1;
        for (int i = 2; i <= n; i++){
            int temp = formerSteps;
            formerSteps += formerFormerSteps;
            formerFormerSteps = temp;
        }
        return formerSteps;
    }
}
