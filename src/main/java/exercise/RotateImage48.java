package exercise;

/**
 * @Author : Ze Li
 * @Date : 25/02/2025 01:04
 * @Version : V1.0
 * @Description :
 */
public class RotateImage48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++){
            for (int j = i; j < n-i-1; j++){
                int temp = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                int temp2 = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = temp;
                int temp3 = matrix[n-j-1][i];
                matrix[n-j-1][i] = temp2;
                matrix[i][j] = temp3;
            }
        }
    }
}
