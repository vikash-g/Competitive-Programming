/**
 * @URL: https://leetcode.com/problems/longest-palindromic-substring/submissions/
 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        return longestPalindrome1(s);
    }

    /**
     * Using DP
     *
     * Time : O(n ^ 2), where n is the length of string
     * Space: O(n ^ 2)
     */
    public String longestPalindrome1(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }

        for (int i = 1; i < n; ++i) {
            if (str[i - 1] == str[i]) {
                start = i - 1;
                maxLen = 2;
                dp[i - 1][i] = true;
            }
        }

        for (int len = 3; len <= n; ++len) {
            for (int i = 0, j = len - 1; j < n; ++i, ++j) {
                if (str[i] == str[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}