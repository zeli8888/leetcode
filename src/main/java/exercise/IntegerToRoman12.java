package exercise;

/**
 * @Author : Ze Li
 * @Date : 26/06/2025 13:50
 * @Version : V1.0
 * @Description :
 */
public class IntegerToRoman12 {
    public String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symble = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<value.length && num>0; i++){
            while(num >= value[i]){
                num -=value[i];
                sb.append(symble[i]);
            }

        }
        return sb.toString();


    }
//    public String intToRoman(int num) {
//        StringBuilder stringBuilder = new StringBuilder();
//        if (num >= 1000) {
//            int divide = num / 1000;
//            int mod = num % 1000;
//            stringBuilder.append("M".repeat(divide));
//            stringBuilder.append(intToRoman(mod));
//        } else if (num >= 900) {
//            stringBuilder.append("CM");
//            stringBuilder.append(intToRoman(num-900));
//        } else if (num >= 500) {
//            stringBuilder.append("D");
//            stringBuilder.append(intToRoman(num-500));
//        } else if (num >= 400) {
//            stringBuilder.append("CD");
//            stringBuilder.append(intToRoman(num-400));
//        } else if (num >= 100) {
//            int divide = num / 100;
//            int mod = num % 100;
//            stringBuilder.append("C".repeat(divide));
//            stringBuilder.append(intToRoman(mod));
//        } else if (num >= 90) {
//            stringBuilder.append("XC");
//            stringBuilder.append(intToRoman(num-90));
//        } else if (num >= 50) {
//            stringBuilder.append("L");
//            stringBuilder.append(intToRoman(num-50));
//        } else if (num >= 40) {
//            stringBuilder.append("XL");
//            stringBuilder.append(intToRoman(num-40));
//        } else if (num >= 10) {
//            int divide = num / 10;
//            int mod = num % 10;
//            stringBuilder.append("X".repeat(divide));
//            stringBuilder.append(intToRoman(mod));
//        } else if (num == 9) {
//            stringBuilder.append("IX");
//        } else if (num >= 5) {
//            stringBuilder.append("V");
//            stringBuilder.append(intToRoman(num-5));
//        } else if (num == 4) {
//            stringBuilder.append("IV");
//        } else if (num >= 1) {
//            stringBuilder.append("I".repeat(num));
//        }
//        return stringBuilder.toString();
//    }
}
