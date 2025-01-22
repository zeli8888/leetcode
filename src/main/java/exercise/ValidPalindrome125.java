package exercise;

import java.util.HashSet;

/**
 * @Author : Ze Li
 * @Date : 22/01/2025 10:00
 * @Version : V1.0
 * @Description :
 */
public class ValidPalindrome125 {
    public static void main(String[] args) {
        ValidPalindrome125 validPalindrome125 = new ValidPalindrome125();
        System.out.println(validPalindrome125.isPalindrome("0P"));
    }
    public boolean isPalindrome(String s) {
        HashSet<Character> NumsAndLetters = new HashSet<>();
        for (int i = 0; i <= 9; i++){
            NumsAndLetters.add((char) ('0'+i));
        }
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (char letter : letters.toCharArray()){
            NumsAndLetters.add(letter);
        }
        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            if (!NumsAndLetters.contains(s.charAt(i))){
                i++;
                continue;
            }
            if (!NumsAndLetters.contains(s.charAt(j))){
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
