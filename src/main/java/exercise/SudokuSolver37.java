package exercise;

/**
 * @Author : Ze Li
 * @Date : 04/03/2025 12:55
 * @Version : V1.0
 * @Description :
 */
public class SudokuSolver37 {
    public void solveSudoku(char[][] board) {
        int numRows = board.length;
        int numColumns = board[0].length;
        char[][] rows_map = new char[numRows][9];
        char[][] columns_map = new char[numColumns][9];

        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numColumns; j++){
                if ()
            }
        }

    }

    private boolean check_valid(char[][] board, int row, int column, char[][] rows_map, char[][] columns_map){
        if (board[row][column] == '.'){
            for (int i = 0; i <= 8; i++){
                if (rows_map[row][i] == 0){
                    board[row][column] = (char) i;
                    rows_map[row][column] = 1;

                    check_valid(board, row, column, rows_map)
                }
            }
        }
    }
}
