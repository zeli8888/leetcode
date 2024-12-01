package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 01/12/2024 19:39
 * @Version : V1.0
 * @Description :
 */
public class LemonadeChange860 {
    public boolean lemonadeChange(int[] bills) {
        int num5 = 0;
        int num10 = 0;
        for (int bill : bills){
            boolean use10 = false;
            if (bill == 5){num5++;}
            if (bill == 10){
                num5 --;
                if (num5 < 0) return false;
                num10 ++;
            }
            if (bill == 20){
                if (num10 > 0) {
                    num10 --;
                    use10 = true;
                }
                if (use10){
                    num5 --;
                }else{
                    num5 -= 3;
                }
                if (num5 < 0) return false;
            }
        }
        return true;
    }
}
