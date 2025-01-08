package exercise;

/**
 * @Author : Ze Li
 * @Date : 08/01/2025 16:44
 * @Version : V1.0
 * @Description :
 */
public class RangeSumQuery2DImmutable304 {
    public static void main(String[] args) {
        int[][] matrix = {{-4,-5}};
        RangeSumQuery2DImmutable304 rangeSumQuery2DImmutable304 = new RangeSumQuery2DImmutable304(matrix);
        System.out.println(rangeSumQuery2DImmutable304.sumRegion(0,0,0,1));
    }
    private int[][] sum;
    public RangeSumQuery2DImmutable304(int[][] matrix) {
        this.sum = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 1; i <= matrix.length; i++){
            for (int j = 1; j <= matrix[0].length; j++){
                this.sum[i][j] = this.sum[i-1][j] + this.sum[i][j-1] - this.sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return this.sum[row2+1][col2+1] - this.sum[row2+1][col1] - this.sum[row1][col2+1] + this.sum[row1][col1];
    }
}
