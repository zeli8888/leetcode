package exercise;

/**
 * @Author : Ze Li
 * @Date : 31/01/2025 11:47
 * @Version : V1.0
 * @Description :
 */
public class GasStation134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < gas.length; i++){
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if (sumGas < sumCost) return -1;

        int curGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                curGas = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
