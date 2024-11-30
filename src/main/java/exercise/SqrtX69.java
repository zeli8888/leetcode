package exercise;

/**
 * @Author : Ze Li
 * @Date : 30/11/2024 14:35
 * @Version : V1.0
 * @Description :
 */
public class SqrtX69 {
    public static void main(String[] args) {
        SqrtX69 sqrtX69 = new SqrtX69();
        System.out.println(sqrtX69.mySqrt(2147395599));
    }
    public int mySqrt(int x) {
        if (x<=1){return x;};
        int low = 0;
        int high = x/2;
        int mid = 0;
        long midSquare = 0;
        while (low <= high){
            mid = (low+high)/2;
            midSquare = (long) mid * mid;
            if (midSquare == x){
                return mid;
            }
            if (midSquare < x){
                low = mid + 1;
            }
            if (midSquare > x){
                high = mid -1;
            }
        }
        return (midSquare>x)?mid-1:mid;
    }
}
