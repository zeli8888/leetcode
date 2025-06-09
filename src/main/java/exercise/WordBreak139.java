package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 09/06/2025 14:59
 * @Version : V1.0
 * @Description :
 */
public class WordBreak139 {
    public static void main(String[] args) {
        WordBreak139 wordBreak139 = new WordBreak139();
        System.out.println(wordBreak139.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")
        ));
    }
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean end;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode trie = new TrieNode();
        TrieNode start = trie;
        for (String word : wordDict) {
            for (char c : word.toCharArray()) {
                if(trie.next[c - 'a'] == null) trie.next[c - 'a'] = new TrieNode();
                trie = trie.next[c - 'a'];
            }
            trie.end = true;
            trie = start;
        }
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return canSegmentString(start, s, 0, memo);
    }

    public boolean canSegmentString(TrieNode root, String s, int start, int[] memo) {
        if (start == s.length()) return true;

        if (memo[start] != -1) return memo[start] == 1;

        TrieNode currentNode = root;
        for (int i = start; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (currentNode.next[index] == null) {
                memo[start] = 0;
                return false;
            }
            currentNode = currentNode.next[index];
            if (currentNode.end && canSegmentString(root, s, i + 1, memo)) {
                memo[start] = 1;
                return true;
            }
        }
        memo[start] = 0;
        return false;
    }
}
