package exercise;

/**
 * @Author : Ze Li
 * @Date : 02/03/2025 21:33
 * @Version : V1.0
 * @Description :
 */
public class SetMatrixZeroes73 {
    public void setZeroes(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] columns = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    rows[i]++;
                    columns[j]++;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++){
            if (rows[i] != 0){
                for (int k = 0; k < matrix[0].length; k++){
                    matrix[i][k] = 0;
                }
            }
        }

        for (int j = 0; j < matrix[0].length; j++){
            if (columns[j] != 0){
                for (int l = 0; l < matrix.length; l++){
                    matrix[l][j] = 0;
                }
            }
        }
    }
}
