package exercise;

/**
 * @Author : Ze Li
 * @Date : 22/05/2025 11:52
 * @Version : V1.0
 * @Description :
 */
public class RansomNote383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letterCounts = new int[26];
        for (char c : magazine.toCharArray()) {
            letterCounts[c-'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            letterCounts[c-'a']--;
        }
        for (int count : letterCounts) {
            if (count < 0) return false;
        }
        return true;
    }
}
