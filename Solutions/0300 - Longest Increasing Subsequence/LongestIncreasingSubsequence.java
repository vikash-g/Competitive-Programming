/**
 * @URL: https://leetcode.com/problems/longest-increasing-subsequence/
 */

public class LongestIncreasingSubsequence {
    /**
     * Time : O(nlog(n))
     * Space: O(n)
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0) {
                index = -(index + 1);
            }

            dp[index] = num;

            if (index == len) {
                ++len;
            }
        }

        return len;
    }
}
