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
        ImplementTriePrefixTree208 curr = this;
        for (char c: word.toCharArray()){
            int index = c - 'a';
            if (curr.node[index] == null){
                curr.node[index] = new ImplementTriePrefixTree208();
            }
            curr = curr.node[index];
        }
        curr.isWord = true;
    }

    private boolean searchWordPrefix(String s, boolean isPrefix) {
        ImplementTriePrefixTree208 curr = this;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (curr.node[index] == null) {
                return false;
            } else {
                curr = curr.node[index];
            }
        }
        return isPrefix || curr.isWord;
    }

    public boolean search(String word) {
        return searchWordPrefix(word, false);
    }

    public boolean startsWith(String prefix) {
        return searchWordPrefix(prefix, true);
    }
}
