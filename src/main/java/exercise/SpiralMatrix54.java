package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 17/02/2025 21:32
 * @Version : V1.0
 * @Description :
 */
public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        int i = 0;
        int numElements = matrix.length * matrix[0].length;
        while (2*i < matrix.length){
            for (int j = i; j < matrix[0].length-i; j++){
                ans.add(matrix[i][j]);
            }
            if (ans.size() == numElements){break;}
            for (int k = i+1; k <= matrix.length-i-2; k++){
                ans.add(matrix[k][matrix[0].length-i-1]);
            }
            for (int j = matrix[0].length-i-1; j>=i; j--){
                ans.add(matrix[matrix.length-i-1][j]);
            }
            if (ans.size() == numElements){break;}
            for (int l =  matrix.length-i-2; l>=i+1; l--){
                ans.add(matrix[l][i]);
            }
            i++;
        }
        return ans;
    }
}
