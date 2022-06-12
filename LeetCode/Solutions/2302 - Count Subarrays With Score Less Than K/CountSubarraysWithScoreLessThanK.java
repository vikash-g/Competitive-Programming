/**
 * @URL: https://leetcode.com/problems/count-subarrays-with-score-less-than-k/
 */

public class CountSubarraysWithScoreLessThanK {
    /**
     * Time : O(n)
     * Space: O(n)
     */
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long[] ps = new long[n];
        ps[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            ps[i] = ps[i - 1] + nums[i];
        }

        long prod = 0;
        int left = 0;
        int right = 0;
        long ans = 0;

        while (left <= right && right < n) {
            long len = (right - left + 1);
            prod = len * (ps[right] - ps[left] + nums[left]);
            if (prod < k) {
                ans += len;
                ++right;
            } else {
                ++left;
                if (left > right) {
                    right = left;
                }
            }
        }

        return ans;
    }
}