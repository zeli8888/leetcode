package exercise;

import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 26/12/2024 15:48
 * @Version : V1.0
 * @Description :
 */
public class PlusOne66 {
    public static void main(String[] args) {
        int[] digits = {9};
        PlusOne66 plusOne66 = new PlusOne66();
        int[] ints = plusOne66.plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // Increment and return if no carry
            }
            digits[i] = 0; // Set to 0 if there's a carry
        }

        // If all digits were 9, create a new array with an extra digit
        int[] result = new int[digits.length + 1];
        result[0] = 1; // Set the first digit to 1
        return result;


    }

//    public int[] plusOne(int[] digits) {
//        int len = digits.length;
//        String stringInteger = "";
//        for (int i = 0; i < len; i++){
//            stringInteger += digits[i];
//        }
//
//        int index = stringInteger.length() - 1;
//        String resultStringInteger = "";
//        while(true){
//            if (index == -1){
//                resultStringInteger = "1" + resultStringInteger;
//                break;
//            }else {
//                char c = stringInteger.charAt(index);
//                if (c != '9'){
//                    resultStringInteger = stringInteger.substring(0, index) + (char)(c+1) + resultStringInteger;
//                    break;
//                }else{
//                    resultStringInteger = '0' + resultStringInteger;
//                }
//            }
//            index --;
//        }
//
//        int[] result = new int[resultStringInteger.length()];
//        for (int i = 0; i < resultStringInteger.length(); i++){
//            result[i] = resultStringInteger.charAt(i) - '0';
//        }
//        return result;
//    }
}
