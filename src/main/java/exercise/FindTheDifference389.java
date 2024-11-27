package exercise;

/**
 * @Author : Ze Li
 * @Date : 26/11/2024 17:43
 * @Version : V1.0
 * @Description :
 */
public class FindTheDifference389 {
    public char findTheDifference(String s, String t) {
        int sum = 0;
        for (char c : t.toCharArray()){
            sum += (int)c;
        }
        for (char c : s.toCharArray()){
            sum -= (int)c;
        }
        return (char)sum;
    }
}
