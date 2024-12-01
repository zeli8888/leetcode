package exercise;

import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 01/12/2024 20:03
 * @Version : V1.0
 * @Description :
 */
public class AssignCookies455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i= g.length-1;
        int j = s.length-1;
        int content = 0;
        while (i >= 0 && j >= 0){
            if (g[i] <= s[j]){
                j--;
                content++;
            }
            i--;
        }
        return content;
    }
}
