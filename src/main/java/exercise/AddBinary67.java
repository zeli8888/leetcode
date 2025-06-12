package exercise;

/**
 * @Author : Ze Li
 * @Date : 12/06/2025 14:25
 * @Version : V1.0
 * @Description :
 */
public class AddBinary67 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            result.append(sum % 2);
            carry = sum / 2;
        }
        return result.reverse().toString();
    }

//    public String addBinary(String a, String b) {
//        int[] carry = new int[Math.max(a.length(), b.length()) + 1];
//        int i = a.length()-1;
//        int j = b.length()-1;
//        int l = 0;
//        StringBuilder stringBuilder = new StringBuilder();
//        while (i >= 0 && j >= 0) {
//            char m = a.charAt(i);
//            char n = b.charAt(j);
//            int val = carry[l] + m - '0' + n - '0';
//            l++;
//            i--;
//            j--;
//            if (val % 2 == 0) {
//                stringBuilder.append('0');
//            }else {
//                stringBuilder.append('1');
//            }
//            carry[l] = val / 2;
//        }
//        while (i >= 0) {
//            char m = a.charAt(i);
//            int val = carry[l] + m - '0';
//            l++;
//            i--;
//            if (val % 2 == 0) {
//                stringBuilder.append('0');
//            }else {
//                stringBuilder.append('1');
//            }
//            carry[l] = val / 2;
//        }
//        while (j >= 0) {
//            char n = b.charAt(j);
//            int val = carry[l] + n - '0';
//            l++;
//            j--;
//            if (val % 2 == 0) {
//                stringBuilder.append('0');
//            }else {
//                stringBuilder.append('1');
//            }
//            carry[l] = val / 2;
//        }
//        while (carry[l] != 0) {
//            int val = carry[l];
//            l++;
//            if (val % 2 == 0) {
//                stringBuilder.append('0');
//            }else {
//                stringBuilder.append('1');
//            }
//            carry[l] = val / 2;
//        }
//        return stringBuilder.reverse().toString();
//    }
}
