package exercise;

/**
 * @Author : Ze Li
 * @Date : 24/01/2025 09:18
 * @Version : V1.0
 * @Description :
 */
public class NumberOf1Bits191 {
    public int hammingWeight(int n) {
        int hammingWeight = 0;
        while (n != 0){
            hammingWeight += n % 2;
            n = n / 2;
        }
        return hammingWeight + n;
    }
}
