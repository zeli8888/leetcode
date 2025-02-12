package exercise;

/**
 * @Author : Ze Li
 * @Date : 12/02/2025 12:33
 * @Version : V1.0
 * @Description :
 */
public class LongestRepeatingCharacterReplacement424 {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int maxFreq = 0;
        int[] freq = new int[26];
        int ans = 0;
        for (int j = 0; j < s.length(); j++){
            int newOne = s.charAt(j)-'A';
            freq[newOne]++;
            maxFreq = Math.max(maxFreq, freq[newOne]);

            while ((j-i+1)-maxFreq > k){
                int disposeOne = s.charAt(i)-'A';
                freq[disposeOne]--;
                i++;
            }

            ans = Math.max(ans, j-i+1);
        }
        return ans;
    }
}
