package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 23/05/2025 14:16
 * @Version : V1.0
 * @Description :
 */
public class LetterCombinationsOfAPhoneNumber17 {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    void backtrack(String digits, int index, StringBuilder curr, List<String> res) {
        if (curr.length() == digits.length()) {
            res.add(curr.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            curr.append(c);
            backtrack(digits, index + 1, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
//    public List<String> letterCombinations(String digits) {
//        if (digits.isEmpty()) return new ArrayList<>();
//        HashMap<Integer, char[]> keyBoard = new HashMap<>();
//        for (int i = 2; i <= 6; i++) {
//            char[] letters = new char[3];
//            for (int j = 0; j <= 2; j++) {
//                letters[j] = (char) ('a' + j + (i-2)*3);
//            }
//            keyBoard.put(i, letters);
//        }
//        keyBoard.put(7, new char[]{'p', 'q', 'r', 's'});
//        keyBoard.put(8, new char[]{'t', 'u', 'v'});
//        keyBoard.put(9, new char[]{'w', 'x', 'y', 'z'});
//
//        HashSet<String> ans = new HashSet<>();
//        helper(digits, 0, ans, "", keyBoard);
//        return new ArrayList<>(ans);
//    }
//
//    public void helper(String digits, int curIndex, HashSet<String> ans, String curString, HashMap<Integer, char[]> keyBoard) {
//        if (curIndex >= digits.length()) {
//            ans.add(curString);
//            return;
//        }
//        char[] letters = keyBoard.get(digits.charAt(curIndex) - '0');
//        for (char l : letters) {
//            helper(digits, curIndex+1, ans, curString+l, keyBoard);
//        }
//
//    }
}
