/**
 * @URL: https://leetcode.com/problems/triangle/
 */

public class Triangle {
    /**
     * Time : O(n^2)
     * Space: O(n)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] dp = new int[rows];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < rows; ++i) {
            dp[i] = Integer.MAX_VALUE;
            List<Integer> row = triangle.get(i);
            for (int j = i; j > 0; --j) {
                dp[j] = row.get(j) + Math.min(dp[j], dp[j - 1]);
            }
            dp[0] += row.get(0);
        }

        int ans = Integer.MAX_VALUE;
        for (int cost : dp) {
            ans = Math.min(ans, cost);
        }
        return ans;
    }
}