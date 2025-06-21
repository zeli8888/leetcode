package exercise;

/**
 * @Author : Ze Li
 * @Date : 21/06/2025 16:03
 * @Version : V1.0
 * @Description :
 */
public class GameOfLife289 {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num_living_neigh = getNumLivingNeigh(board, i, j);
                if (num_living_neigh == 3 || board[i][j] == 1 && num_living_neigh == 2) board[i][j] += 2;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) board[i][j] = 0;
                else if (board[i][j] == 2 || board[i][j] == 3) board[i][j] = 1;
            }
        }
    }

    private int getNumLivingNeigh(int[][] board, int i, int j) {
        int num_living_neigh = 0;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] % 2 == 1) {
                num_living_neigh++;
                if (num_living_neigh == 4) break;
            }
        }
        return num_living_neigh;
    }
}
