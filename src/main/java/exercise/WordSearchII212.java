package exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 30/04/2025 14:33
 * @Version : V1.0
 * @Description :
 */
public class WordSearchII212 {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            buildTrieNode(word, root);
        }

        List<String> ans = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                DFS(board, root, ans, i, j);
            }
        }
        return ans;
    }

    public void DFS(char[][] board, TrieNode root, List<String> ans, int i, int j) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) return;
        char c =  board[i][j];
        if (c == '#') return;
        int index = c - 'a';
        if (root.next[index] == null) return;
        board[i][j] = '#';
        root = root.next[index];
        if (root.word != null) {ans.add(root.word);root.word=null;}
        DFS(board, root, ans, i+1, j);
        DFS(board, root, ans, i, j+1);
        DFS(board, root, ans, i, j-1);
        DFS(board, root, ans, i-1, j);
        board[i][j] = c;
    }

    public void buildTrieNode(String word, TrieNode root) {
        for (char c : word.toCharArray()) {
            if (root.next[c-'a'] == null) root.next[c-'a'] = new TrieNode();
            root = root.next[c-'a'];
        }
        root.word = word;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}
