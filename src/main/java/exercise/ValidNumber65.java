package exercise;

/**
 * @Author : Ze Li
 * @Date : 01/07/2025 17:43
 * @Version : V1.0
 * @Description :
 */
public class ValidNumber65 {
    public static void main(String[] args) {
        Solution solution = new ValidNumber65().new Solution();
        System.out.println(solution.isNumber("0.."));
    }
    class Solution {
        int index = 0;
        public boolean isNumber(String s) {
            if (isInteger(s) && isExponent(s)) return true;
            index = 0;
            return isDecimal(s) && isExponent(s);
        }

        private boolean isInteger(String s) {
            if (index >= s.length()) return false;
            if (s.charAt(index) == '-' || s.charAt(index) == '+') index++;
            return isDigits(s);
        }

        private boolean isDigits(String s) {
            if (index >= s.length()) return false;
            if (!Character.isDigit(s.charAt(index))) return false;
            do index++;
            while (index < s.length() && Character.isDigit(s.charAt(index)));
            return true;
        }

        private boolean isDecimal(String s) {
            if (index >= s.length()-1) return false;
            if (s.charAt(index) == '-' || s.charAt(index) == '+') index++;
            int indexCopy = index;
            if (isDigits(s) && s.charAt(index++) == '.') {
                isDigits(s);
                return true;
            }else {
                index = indexCopy;
                return s.charAt(index++) == '.' && isDigits(s);
            }
        }

        private boolean isExponent(String s) {
            if (index >= s.length()) return true;
            if (s.charAt(index) == 'e' || s.charAt(index) == 'E') {
                index++;
                return isInteger(s) && index >= s.length();
            }
            return false;
        }
    }
}
