package exercise;

/**
 * @Author : Ze Li
 * @Date : 11/03/2025 15:30
 * @Version : V1.0
 * @Description :
 */
public class SearchA2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
