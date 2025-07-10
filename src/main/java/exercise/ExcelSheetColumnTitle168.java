package exercise;

/**
 * @Author : Ze Li
 * @Date : 10/07/2025 15:02
 * @Version : V1.0
 * @Description :
 */
public class ExcelSheetColumnTitle168 {
    class Solution {
        public String convertToTitle(int columnNumber) {
            int start = 'A';
            StringBuilder stringBuilder = new StringBuilder();
            while (columnNumber != 0) {
                columnNumber--;
                int val = columnNumber % 26;
                stringBuilder.append((char) (val+start));
                columnNumber = columnNumber / 26;
            }
            return stringBuilder.reverse().toString();
        }
    }
}
