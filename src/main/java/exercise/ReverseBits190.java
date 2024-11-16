package exercise;

/**
 * @Author : Ze Li
 * @Date : 16/11/2024 18:26
 * @Version : V1.0
 * @Description :
 */
public class ReverseBits190 {
    public static void main(String[] args) {
        ReverseBits190 reverseBits190 = new ReverseBits190();
        System.out.println(reverseBits190.reverseBits(4294967293L));
    }
    // you need treat n as an unsigned value
    public long reverseBits(long n) {
        long num = 0;
        int bit = 0;
        while(n != 0){
            num += (n % 2) * Math.pow(2, 31-bit);
            bit++;
            n = n / 2;
        }
        return num;
    }
}
