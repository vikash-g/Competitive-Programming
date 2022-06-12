/**
 * @URL: https://leetcode.com/problems/minimum-path-cost-in-a-grid/
 */

public class MinimumPathCostInAGrid {
    /**
     * Time : O(m * n^2)
     * Space: O(m * n)
     */
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int j = 0; j < n; ++j) {
            dp[0][j] = grid[0][j];
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int minCost = Integer.MAX_VALUE;
                for (int k = 0; k < n; ++k) {
                    minCost = Math.min(minCost, dp[i - 1][k] + moveCost[grid[i - 1][k]][j]);
                }
                dp[i][j] = grid[i][j] + minCost;
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int cost : dp[m - 1]) {
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }
}