/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 */

public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        // return minDistance1(word1, word2);
        return minDistance2(word1, word2);
    }

    /**
     * Find the longest common subsequence and remove all the other characters from two strings.
     *
     * Time : O(m * n)
     * Space: O(m * n)
     */
    public int minDistance1(String word1, String word2) {
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int m = s.length;
        int n = t.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (s[i] == t[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return m + n - (dp[m][n] << 1);
    }

    /**
     * This method also finds longest common subsequence but it uses less memory.
     * Time : O(m * n)
     * Space: O(2 * Min(m, n))
     */
    public int minDistance2(String word1, String word2) {
        if (word1.length() > word2.length()) {
            return minDistance(word2, word1);
        }

        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int m = s.length;
        int n = t.length;
        int[][] dp = new int[2][m + 1];
        int k = 0;
        for (int i = 0; i < n; ++i) {
            k = 1 - k;
            for (int j = 0; j < m; ++j) {
                if (s[j] == t[i]) {
                    dp[k][j + 1] = dp[1 - k][j] + 1;
                } else {
                    dp[k][j + 1] = Math.max(dp[k][j], dp[1 - k][j + 1]);
                }
            }
        }
        return m + n - (dp[k][m] << 1);
    }
}
