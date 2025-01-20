package exercise;

/**
 * @Author : Ze Li
 * @Date : 20/01/2025 13:32
 * @Version : V1.0
 * @Description :
 */
public class CoinChangeII518 {
    public static void main(String[] args) {
        CoinChangeII518 coinChangeII518 = new CoinChangeII518();
        System.out.println(coinChangeII518.change(500, new int[]{1,2,5}));
    }
    public int change(int amount, int[] coins) {
        int[] combinations = new int[amount + 1];
        combinations[0] = 1;
        for (int coin : coins){
            for (int i = coin; i <= amount; i++){
                combinations[i] += combinations[i - coin];
            }
        }
        return combinations[amount];
    }
}
