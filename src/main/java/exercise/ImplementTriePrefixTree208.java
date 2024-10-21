package exercise;

/**
 * @Author : Ze Li
 * @Date : 21/10/2024 13:26
 * @Version : V1.0
 * @Description :
 */
public class ImplementTriePrefixTree208 {
    boolean isWord;
    ImplementTriePrefixTree208[] node = new ImplementTriePrefixTree208[26];
    public ImplementTriePrefixTree208() {
    }

    public void insert(String word) {
        ImplementTriePrefixTree208 cur = this;
        for(char idx: word.toCharArray()) {
            idx -= 'a';
            if(cur.node[idx] == null)
                cur.node[idx] = new ImplementTriePrefixTree208();
            cur = cur.node[idx];
        }
        cur.isWord = true;
    }

    private boolean searchWordPrefix(String s, boolean isPrefix) {
        ImplementTriePrefixTree208 cur = this;
        for(char idx: s.toCharArray()) {
            idx -= 'a';
            if(cur.node[idx] == null)
                return false;
            cur = cur.node[idx];
        }
        return isPrefix || cur.isWord;
    }

    public boolean search(String word) {
        return searchWordPrefix(word, false);
    }

    public boolean startsWith(String prefix) {
        return searchWordPrefix(prefix, true);
    }
}
