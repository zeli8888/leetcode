package exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Ze Li
 * @Date : 14/03/2025 15:24
 * @Version : V1.0
 * @Description :
 */
public class Matrix542 {

    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return new int[0][0];

        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int MAX_VALUE = m * n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = MAX_VALUE;
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : directions) {
                int r = cell[0] + dir[0], c = cell[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] > mat[cell[0]][cell[1]] + 1) {
                    queue.offer(new int[]{r, c});
                    mat[r][c] = mat[cell[0]][cell[1]] + 1;
                }
            }
        }

        return mat;
    }
//    public int[][] updateMatrix(int[][] mat) {
//        int m = mat.length;
//        int n = mat[0].length;
//        int[][] ans = new int[m][n];
//        Arrays.stream(ans).forEach(row -> Arrays.fill(row, -1));
//        for (int i = 0; i < m; i++){
//            for (int j = 0; j < n; j++){
//                if (mat[i][j] == 0){
//                    ans[i][j] = 0;
//                }
//            }
//        }
//        int fillElement = 0;
//        while (true){
//            boolean noUpdate = true;
//            for (int i = 0; i < m; i++){
//                for (int j = 0; j < n; j++){
//                    if (ans[i][j] == fillElement){
//                        if (i >= 1 && ans[i-1][j] == -1){
//                            noUpdate = false;
//                            ans[i-1][j] = fillElement+1;
//                        }
//                        if (i <= m-2 && ans[i+1][j] == -1){
//                            noUpdate = false;
//                            ans[i+1][j] = fillElement+1;
//                        }
//                        if (j >= 1 && ans[i][j-1] == -1){
//                            noUpdate = false;
//                            ans[i][j-1] = fillElement+1;
//                        }
//                        if (j <= n-2 && ans[i][j+1] == -1){
//                            noUpdate = false;
//                            ans[i][j+1] = fillElement+1;
//                        }
//                    }
//                }
//            }
//            if (noUpdate){return ans;}
//            fillElement++;
//        }
//    }
}
