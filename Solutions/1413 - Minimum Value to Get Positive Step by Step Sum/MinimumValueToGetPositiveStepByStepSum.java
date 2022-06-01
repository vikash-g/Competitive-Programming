/**
 * @URL: https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 */

public class MinimumValueToGetPositiveStepByStepSum {
    /**
     * Time : O(n)
     * Space: O(1)
     */
    public int minStartValue(int[] nums) {
        int min = nums[0];
        int runningSum = 0;
        for (int num : nums) {
            runningSum += num;
            min = Math.min(min, runningSum);
        }

        return min <= 0 ? Math.abs(min) + 1 : 1;
    }
}
