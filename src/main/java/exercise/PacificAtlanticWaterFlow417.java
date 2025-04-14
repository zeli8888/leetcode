package exercise;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 14/04/2025 10:05
 * @Version : V1.0
 * @Description :
 */
public class PacificAtlanticWaterFlow417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] toPacific = new boolean[m][n];
        boolean[][] toAtlantic = new boolean[m][n];
        int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> toPacificQueue = new LinkedList<int[]>();
        Queue<int[]> toAtlanticQueue = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            toPacific[i][0] = true;
            toPacificQueue.add(new int[] {i, 0});
            toAtlantic[i][n-1] = true;
            toAtlanticQueue.add(new int[] {i, n-1});
        }
        for (int j = 0; j < n; j++) {
            toPacific[0][j] = true;
            toPacificQueue.add(new int[] {0, j});
            toAtlantic[m-1][j] = true;
            toAtlanticQueue.add(new int[] {m-1, j});
        }

        while (!toPacificQueue.isEmpty()) {
            int[] index = toPacificQueue.poll();
            reverseFlow(heights, toPacific, index, direction, toPacificQueue);
        }

        while (!toAtlanticQueue.isEmpty()) {
            int[] index = toAtlanticQueue.poll();
            reverseFlow(heights, toAtlantic, index, direction, toAtlanticQueue);
        }

        LinkedList<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (toPacific[i][j] && toAtlantic[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }

    public void reverseFlow(int[][] heights, boolean[][] toOcean, int[] index, int[][] direction, Queue<int[]> toOceanQueue) {
        int m = heights.length;;
        int n = heights[0].length;
        for (int[] direct : direction) {
            int p = index[0] + direct[0];
            int q = index[1] + direct[1];
            if (p >= 0 && p < m && q >= 0 && q < n && !toOcean[p][q] && heights[p][q] >= heights[index[0]][index[1]]) {
                toOcean[p][q] = true;
                toOceanQueue.add(new int[] {p, q});
            }
        }
    }
}
