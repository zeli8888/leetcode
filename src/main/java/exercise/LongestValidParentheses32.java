package exercise;

import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 05/06/2025 15:40
 * @Version : V1.0
 * @Description :
 */
public class LongestValidParentheses32 {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses32().longestValidParentheses(")))()"));
    }
    public int longestValidParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int maxlen=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    maxlen=Math.max(maxlen,i-st.peek());
                }
            }
        }
        return maxlen;

    }
}
