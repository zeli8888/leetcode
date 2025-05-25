package exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 24/05/2025 18:35
 * @Version : V1.0
 * @Description :
 */
public class NQueens51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        LinkedList<List<String>> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        fillQueen(ans, board,0);
        return ans;
    }

    public void fillQueen(List<List<String>> ans, char[][] board, int column) {
        int n = board.length;
        if (column == n) {
            LinkedList<String> curAns = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                curAns.add(new String(board[i]));
            }
            ans.add(curAns);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (checkCollision(board, column, row)) {
                board[row][column] = 'Q';
                fillQueen(ans, board, column+1);
                board[row][column] = '.';
            }
        }
    }

    public boolean checkCollision(char[][] board, int column, int row) {
        for (int i = 0; i < column; i++){
            if (board[row][i] == 'Q') return false;
        }
        int j = column-1;
        for (int i = row-1; i >= 0 && j >= 0; i--) {
            if (board[i][j] == 'Q') return false;
            j--;
        }
        j = column-1;
        for (int i = row+1; i < board.length && j >= 0; i++) {
            if (board[i][j] == 'Q') return false;
            j--;
        }
        return true;
    }
}
