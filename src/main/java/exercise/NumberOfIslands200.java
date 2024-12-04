package exercise;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @Author : Ze Li
 * @Date : 03/12/2024 23:22
 * @Version : V1.0
 * @Description :
 */
public class NumberOfIslands200 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1'}, {'0','1','0'},{'1','1','1'}
        };
        System.out.println(new NumberOfIslands200().numIslands(grid));
    }

    int rows;
    int cols;
    int island = 0;

    public int numIslands(char[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            search(grid, row);
        }
        return island;

    }

    public void search(char[][] grid, int row) {
        char[] finalrow = grid[row];

        for (int col = 0; col < cols; ++col) {
            if (finalrow[col] == '1') {
                mark(grid, row, col);
                ++island;
            }
        }
    }

    public void mark(char[][] grid, int row, int col) {
        grid[row][col] = '*';

        if (row > 0 && grid[row - 1][col] == '1')
            mark(grid, row - 1, col);
        if (row + 1 < rows && grid[row + 1][col] == '1')
            mark(grid, row + 1, col);
        if (col > 0 && grid[row][col - 1] == '1')
            mark(grid, row, col - 1);
        if (col + 1 < cols && grid[row][col + 1] == '1')
            mark(grid, row, col + 1);
    }
//    public int numIslands(char[][] grid) {
//        int num = 0;
//        HashSet<String> checkedPos = new HashSet<>();
//        for (int i = 0; i < grid.length; i++){
//            for (int j = 0; j < grid[0].length; j++){
//                String pos = i + "," + j;
//                if (grid[i][j] == '1' && !checkedPos.contains(pos)){
//                    LinkedList<int[]> island = new LinkedList<>();
//                    num++;
//                    checkedPos.add(pos);
//                    island.add(new int[]{i,j});
//                    while(!island.isEmpty()){
//                        int[] polledIsland = island.poll();
//                        int x = polledIsland[0];
//                        int y = polledIsland[1];
//                        pos = x+1 + "," + y;
//                        if (x+1 < grid.length && !checkedPos.contains(pos) && grid[x+1][y] == '1') {
//                            checkedPos.add(pos);
//                            island.add(new int[]{x+1,y});
//                        }
//                        pos = x-1 + "," + y;
//                        if (x-1 >= 0 && !checkedPos.contains(pos) && grid[x-1][y] == '1') {
//                            checkedPos.add(pos);
//                            island.add(new int[]{x-1,y});
//                        }
//                        pos = x + "," + (y+1);
//                        if (y+1 < grid[0].length && !checkedPos.contains(pos) && grid[x][y+1] == '1') {
//                            checkedPos.add(pos);
//                            island.add(new int[]{x, y+1});
//                        }
//                        pos = x + "," + (y-1);
//                        if (y-1 >= 0 && !checkedPos.contains(pos) && grid[x][y-1] == '1') {
//                            checkedPos.add(pos);
//                            island.add(new int[]{x, y-1});
//                        }
//                    }
//                }
//            }
//        }
//        return num;
//    }
}
