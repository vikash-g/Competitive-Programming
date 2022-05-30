/**
 * @URL: https://leetcode.com/problems/missing-number/
 */

public class MissingNumber {
    public int missingNumber(int[] nums) {
        return missingNumber1(nums);
        // return missingNumber2(nums);
    }

    /**
     * Time : O(n)
     * Space: O(1)
     */
    public int missingNumber1(int[] nums) {
        int n = nums.length;
        int missing = 0;
        for (int i = 0; i < n; ++i) {
            missing ^= nums[i] ^ (i + 1);
        }
        return missing;
    }

    /**
     * Time : O(n)
     * Space: O(1)
     */
    public int missingNumber2(int[] nums) {
        int missing = xorOfOneToN(nums.length);
        for (int num : nums) {
            missing ^= num;
        }
        return missing;
    }

    private int xorOfOneToN(int n) {
        /**
         * Reference: https://www.geeksforgeeks.org/calculate-xor-1-n/
         * 
         * Efficient method of finding the xor
         * Find the remainder of n by moduling it with 4.
         * If rem = 0, then xor will be same as n. 
         * If rem = 1, then xor will be 1. 
         * If rem = 2, then xor will be (n + 1). 
         * If rem = 3, then xor will be 0.
         */
        return new int[]{n, 1, n + 1, 0}[n & 3];
    }
}