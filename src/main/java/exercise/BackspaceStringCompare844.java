package exercise;

/**
 * @Author : Ze Li
 * @Date : 02/06/2025 10:48
 * @Version : V1.0
 * @Description :
 */
public class BackspaceStringCompare844 {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        while (i >= 0 || j >= 0) {
            i = nextValidIndex(s, i);
            j = nextValidIndex(t, j);
            if (i == -1 && j == -1) {
                return true;
            }
            if (i == -1 || j == -1 || s.charAt(i) != t.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public int nextValidIndex(String s, int curIndex) {
        int numSkip = 0;
        while (curIndex >= 0) {
            if (s.charAt(curIndex) == '#') {
                numSkip++;
            } else if (numSkip > 0) {
                numSkip--;
            } else {
                return curIndex;
            }
            curIndex--;
        }
        return -1;
    }
}
