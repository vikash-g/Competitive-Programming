/**
 * @URL: https://leetcode.com/problems/palindromic-substrings/
 */

public class PalindromicSubstrings {
    /**
     * Time : O(n^2)
     * Space: O(n^2)
     */
    public int countSubstrings(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        boolean[][] dp = new boolean[n][n];
        int count = n;

        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
            if (i < n - 1 && str[i] == str[i + 1]) {
                ++count;
                dp[i][i + 1] = true;
            }
        }

        for (int i = 3; i <= n; ++i) {
            int substringCount = n - i;
            for (int j = 0, k = j + i - 1; j <= substringCount; ++j, ++k) {
                if (str[j] == str[k] && dp[j + 1][k - 1]) {
                    dp[j][k] = true;
                    ++count;
                }
            }
        }
        return count;
    }
}
