package exercise;

/**
 * @Author : Ze Li
 * @Date : 22/01/2025 10:21
 * @Version : V1.0
 * @Description :
 */
public class StringToIntegerAtoi8 {
    public int myAtoi(String s) {
        String ans = "";
        char[] sChar = s.toCharArray();
        boolean signChecked = false;
        boolean positive = true;
        boolean spaceLeading = true;
        for (char c : sChar){
            if (spaceLeading && c == ' '){
                continue;
            }else{
                spaceLeading = false;
            }
            if (!signChecked && c == '-'){
                positive = false;
                signChecked = true;
                continue;
            }
            if (c <= '9' && c >= '0'){
                signChecked = true;
                int num = c - '0';
                ans += num;
                signChecked = true;
            }else{
                break;
            }
        }
        if (ans.isEmpty()){
            return 0;
        }
        String minIntVal = String.valueOf(Integer.MIN_VALUE);
        String maxIntVal = String.valueOf(Integer.MAX_VALUE);
        if (positive){
            if ()
        }
    }
}
