/**
 * @URL: https://leetcode.com/problems/ones-and-zeroes/
 */

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3));
        System.out.println(solution.findMaxForm(new String[]{"10","0","1"}, 1, 1));
        System.out.println(solution.findMaxForm(new String[]{"11111","100","1101","1101","11000"}, 5, 7));
        System.out.println(solution.findMaxForm(new String[]{"111","1000","1000","1000"}, 9, 3));
    }

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
