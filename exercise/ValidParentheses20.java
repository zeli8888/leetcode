import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 18/10/2024 10:46
 * @Version : V1.0
 * @Description :
 */
public class ValidParentheses20 {
    public static void main(String[] args) {
        String s = "(){}}{";
        System.out.println(new ValidParentheses20().isValid(s));
    }
    public boolean isValid(String s) {
        Stack<Character> inputString = new Stack<>();
        if (s.length() % 2 != 0) return false;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                inputString.push(c);
            }
            else if (i == 0){
                return false;
            }
            else{
                try {
                    switch (c) {
                    case ')':
                        if(inputString.pop() != '(') return false;
                        continue;
                    case ']':
                        if(inputString.pop() != '[') return false;
                        continue;
                    case '}':
                        if(inputString.pop() != '{') return false;
                        continue;}
                }catch (Exception e){
                    return false;
                    }
            }
        }
        return inputString.isEmpty();
    }
}
