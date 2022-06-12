/**
 * @URL: https://leetcode.com/problems/maximum-erasure-value/
 */

public class MaximumErasureValue {
    /**
     * Time : O(n)
     * Space: O(n)
     */
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] ps = new int[n + 1];
        int[] map = new int[(int)1e4 + 1];
        int start = 0;
        int maxScore = 0;

        for (int i = 0; i < n; ++i) {
            ps[i + 1] = ps[i] + nums[i];
            int lastIndex = map[nums[i]];
            if (lastIndex != 0 && lastIndex >= start) {
                maxScore = Math.max(maxScore, ps[i] - ps[start]);
                start = lastIndex;
            }
            map[nums[i]] = i + 1;
        }

        return Math.max(maxScore, ps[n] - ps[start]);
    }
}