package exercise;

/**
 * @Author : Ze Li
 * @Date : 15/06/2025 13:40
 * @Version : V1.0
 * @Description :
 */
public class PowXN50 {
    public double myPow(double x, int n) {
        if (x == 1.0) return 1.0;
        if (x == -1.0) {
            if (n % 2 == 1) return -1.0;
            else return 1.0;
        }
        if (x == 0) return 0.0;
        if (n == 0) return 1.0;

        double ans = x;
        if (n == Integer.MIN_VALUE) {
            for (int i = 1; i < Math.abs(n+1); i++) {
                ans *= x;
            }
            ans *= x;
        }else {
            for (int i = 1; i < Math.abs(n); i++) {
                ans *= x;
            }
        }
        if (n < 0) return 1/ans;
        return ans;
    }
}
