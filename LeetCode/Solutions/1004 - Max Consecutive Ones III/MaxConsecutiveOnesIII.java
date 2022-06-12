/**
 * @URL: https://leetcode.com/problems/max-consecutive-ones-iii/
 */

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        // return longestOnes1(nums, k);
        return longestOnes2(nums, k);
    }

    /**
     * Time : O(n)
     * Space: O(1)
     */
    public int longestOnes1(int[] nums, int k) {
        int n = nums.length;
        if (k == n) {
            return n;
        }

        int start = 0;
        int maxLen = 0;
        int countZeros = 0; // track the number of zeros in the window

        for (int i = 0; i < n; ++i) {
            countZeros += 1 - nums[i];
            // the window won't be consecutive 1's after k flips, we have to shrink the window
            while (start <= i && countZeros > k) {
                countZeros += nums[start++] - 1;
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }

    /**
     * Time : O(n)
     * Space: O(1)
     */
    public int longestOnes2(int[] nums, int k) {
        int n = nums.length;
        if (k == n) {
            return n;
        }

        int start = 0;
        int countZeros = 0; // track the number of zeros in the window

        for (int i = 0; i < n; ++i) {
            countZeros += 1 - nums[i];
            if (countZeros > k) {
                // the window won't be consecutive 1's after k flips, we have to shrink the window
                countZeros += nums[start++] - 1;
            }
        }

        return n - start;
    }
}
