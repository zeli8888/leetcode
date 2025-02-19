package exercise;

/**
 * @Author : Ze Li
 * @Date : 19/02/2025 14:42
 * @Version : V1.0
 * @Description :
 */
public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        int[] record;
        for(int i = 0; i < board.length; i++){
            record = new int[9];
            int[] columnRecord = new int[9];
            int c;
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.'){
                    continue;
                }else{
                    c = board[i][j] - '1';
                }
                if (record[c] != 0){
                    return false;
                }else{
                    record[c]++;
                }
                if (board[j][i] == '.'){
                    c = 0;
                }else{
                    c = board[j][i] - '0';
                }
                if (columnRecord[c] != 0){
                    return false;
                }else{
                    columnRecord[c]++;
                }
            }
        }
        for (int i = 0; i<=6; i+=3){
            for (int j = 0; j<=6; j+=3){
                record = new int[9];
                int c;
                for (int m = i; m<3+i; m++){
                    for (int n = i; n<3+j; j++){
                        if (board[i][j] == '.'){
                            continue;
                        }else{
                            c = board[i][j] - '1';
                        }
                        if (record[c] != 0){
                            return false;
                        }else{
                            record[c]++;
                        }
                    }
                }
            }
        }
        return true;
    }
}
