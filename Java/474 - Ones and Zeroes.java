/**
 * @URL: https://leetcode.com/problems/ones-and-zeroes/
 */

// Time : O(L * m * n), where L is given string array size.
// Space: O(m * n)
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for (String str : strs) {
            int zeroes = str.replace("1", "").length();
            int ones = str.length() - zeroes;
            
            for (int i = m; i >= zeroes; --i) {
                for (int j = n; j >= ones; --j) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeroes][j - ones]);
                }
            }
        }
        return dp[m][n];
    }
}
