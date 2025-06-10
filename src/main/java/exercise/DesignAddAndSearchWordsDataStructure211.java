package exercise;

/**
 * @Author : Ze Li
 * @Date : 10/06/2025 12:37
 * @Version : V1.0
 * @Description :
 */
public class DesignAddAndSearchWordsDataStructure211 {
    class WordDictionary {
        TrieNode root;

        class TrieNode {
            TrieNode[] next = new TrieNode[26];
            boolean end;
        }

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) node.next[c - 'a'] = new TrieNode();
                node = node.next[c - 'a'];
            }
            node.end = true;
        }

        public boolean search(String word) {
            return helper(word, 0, root);
        }

        public boolean helper(String word, int start, TrieNode node) {
            if (start == word.length()) return node.end;
            char c = word.charAt(start);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.next[j] == null) continue;
                    if (helper(word, start+1, node.next[j])) return true;
                }
                return false;
            }
            else if (node.next[c - 'a'] == null) return false;
            else {
                return helper(word, start+1, node.next[c - 'a']);
            }
        }
    }
}
