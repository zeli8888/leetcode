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
        if (amount == 0) return 1;
        int[] combinations = new int[amount + 1];
        for (int i = 0; i <= amount; i++){
            for (int coin : coins){
                if (i < coin) continue;
                if (i % coin == 0) {combinations[i]++;
                }else if (combinations[i - coin] != 0) {
                    combinations[i] = combinations[i - coin] + 1;
                }
            }
        }
        return combinations[amount];
    }
}
