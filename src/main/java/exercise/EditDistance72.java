package exercise;

/**
 * @Author : Ze Li
 * @Date : 18/12/2024 21:19
 * @Version : V1.0
 * @Description :
 */
public class EditDistance72 {
    public static void main(String[] args) {
        EditDistance72 editDistance72 = new EditDistance72();
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(editDistance72.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()){
            return word2.length();
        } else if (word2.isEmpty()) {
            return word1.length();
        }

        // dp[i][j] means minimal steps needed to transform first i chars of word1 to first j chars of word2
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < dp.length; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j < dp[0].length; j++){
            dp[0][j] = j;
        }
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    int deleteDis = 1 + dp[i-1][j];
                    int replaceDis = 1 + dp[i-1][j-1];
                    int insertDis = 1 + dp[i][j-1];
                    dp[i][j] = Math.min(Math.min(deleteDis, replaceDis), insertDis);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

//    public int minDistance(String word1, String word2) {
//        return minDistance(word1, word2, 0);
//    }
//
//    public int minDistance(String word1, String word2, int index) {
//        if (index >= word1.length() && index < word2.length()){
//            return word2.length() - word1.length();
//        } else if (index >= word2.length()){
//            return word1.length() - word2.length();
//        }
//        int minOp = word1.length();
//        char c = word2.charAt(index);
//        // insert
//        int insertDis = minDistance(word1.substring(0, index) + c + word1.substring(index), word2, index + 1) + 1;
//
//        // delete
//        int deleteDis = minDistance(word1.substring(0, index) + word1.substring(index + 1), word2, index) + 1;
//
//        int replaceDis = insertDis;
//        int continueDis = insertDis;
//        if (word1.charAt(index) != c) {
//            // replace
//            replaceDis = minDistance(word1.substring(0, index) + c + word1.substring(index + 1), word2, index + 1) + 1;
//        }else{
//            continueDis = minDistance(word1, word2, index+1);
//        }
//
//        minOp = Math.min(Math.min(Math.min(Math.min(minOp, replaceDis), insertDis), deleteDis), continueDis);
//
//        return minOp;
//    }
}
