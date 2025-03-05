package exercise;

/**
 * @Author : Ze Li
 * @Date : 04/03/2025 12:55
 * @Version : V1.0
 * @Description :
 */
public class SudokuSolver37 {
    public static void main(String[] args) {
        SudokuSolver37 sudokuSolver37 = new SudokuSolver37();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        sudokuSolver37.solveSudoku(board);
    }
    public void solveSudoku(char[][] board) {
        int numRows = board.length;
        int numColumns = board[0].length;
        char[][] rows_map = new char[numRows][9];
        char[][] columns_map = new char[numColumns][9];
        char[][] box_map = new char[9][9];
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numColumns; j++){
                if (board[i][j] != '.'){
                    int val = board[i][j] - '0' - 1;
                    int box = i/3*3+j/3;
                    rows_map[i][val] = 1;
                    columns_map[j][val] = 1;
                    box_map[box][val] = 1;
                }
            }
        }

        helper(board, 0, 0, rows_map, columns_map, box_map);

    }

    private boolean helper(char[][] board, int i, int j, char[][] rows_map, char[][] columns_map, char[][] box_map){
        if (i >= 9){return true;}
        int next_i = (i*9+j+1)/9;
        int next_j = (i*9+j+1)%9;
        if (board[i][j] == '.'){
            int box = i/3*3+j/3;
            for (int val = 0; val <= 8; val++){
                if (rows_map[i][val] == 0 && columns_map[j][val] == 0 && box_map[box][val] == 0){
                    board[i][j] = (char) (val+1 + '0');
                    rows_map[i][val] = 1;
                    columns_map[j][val] = 1;
                    box_map[box][val] = 1;

                    if (!helper(board, next_i, next_j, rows_map, columns_map, box_map)){
                        board[i][j] = '.';
                        rows_map[i][val] = 0;
                        columns_map[j][val] = 0;
                        box_map[box][val] = 0;
                    }else{
                        return true;
                    }
                }
            }
            return false;
        }
        return helper(board, next_i, next_j, rows_map, columns_map, box_map);
    }
}
