package exercise;

/**
 * @Author : Ze Li
 * @Date : 22/01/2025 10:21
 * @Version : V1.0
 * @Description :
 */
public class StringToIntegerAtoi8 {
    public static void main(String[] args) {
        StringToIntegerAtoi8 stringToIntegerAtoi8 = new StringToIntegerAtoi8();
        System.out.println(stringToIntegerAtoi8.myAtoi("-+12"));
    }

    public int myAtoi(String s) {
        int INT_MAX = 2147483647, INT_MIN = -2147483648;
        int i = 0, n = s.length(), sign = 1, result = 0;

        // Step 1: Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') i++;

        // Step 2: Check for optional sign
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        // Step 3: Convert digits to integer
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            // Check for overflow
            if (result > (INT_MAX - digit) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }
            result = result * 10 + digit;
            i++;
        }

        return sign * result;
    }

//    public int myAtoi(String s) {
//        String ans = "";
//        char[] sChar = s.toCharArray();
//        boolean signChecked = false;
//        boolean spaceLeading = true;
//        boolean zeroLeading = true;
//        for (char c : sChar){
//            if (spaceLeading && c == ' '){
//                continue;
//            }else{
//                spaceLeading = false;
//            }
//            if (!signChecked && c == '-'){
//                ans += "-";
//                signChecked = true;
//                continue;
//            }
//
//            if (!signChecked && c == '+'){
//                signChecked = true;
//                continue;
//            }
//
//            if (zeroLeading && c == '0'){
//                signChecked = true;
//                continue;
//            }
//            if (c <= '9' && c >= '0'){
//                int num = c - '0';
//                ans += num;
//                signChecked = true;
//                zeroLeading = false;
//            } else{
//                break;
//            }
//        }
//        if (ans.isEmpty() || ans.equals("-")){
//            return 0;
//        }
//        String minIntVal = String.valueOf(Integer.MIN_VALUE);
//        String maxIntVal = String.valueOf(Integer.MAX_VALUE);
//        if (ans.charAt(0) != '-'){
//            if (ans.length() > maxIntVal.length() ||
//                    Long.parseLong(ans) > Integer.MAX_VALUE) return Integer.MAX_VALUE;
//            return Integer.parseInt(ans);
//        }else{
//            if (ans.length() > minIntVal.length() ||
//                    Long.parseLong(ans) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
//            return Integer.parseInt(ans);
//        }
//    }
}
