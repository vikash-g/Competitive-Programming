/**
 * @URL: https://leetcode.com/problems/running-sum-of-1d-array/
 */

public class RunningSumOf1dArray {
    /**
     * Time : O(n)
     * Space: O(1)
     */
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
