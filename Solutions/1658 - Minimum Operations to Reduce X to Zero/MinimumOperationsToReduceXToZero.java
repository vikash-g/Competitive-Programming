/**
 * @URL: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 */

public class MinimumOperationsToReduceXToZero {
    /**
     * Time : O(n)
     * Space: O(n)
     */
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        if (nums[0] == x || nums[n - 1] == x) {
            return 1;
        }

        int totalSum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            totalSum += num;
            if (num < min) {
                min = num;
            }
        }
        if (min > x || totalSum < x) {
            return -1;
        }
        if (totalSum == x) {
            return n;
        }

        int target = totalSum - x;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currentSum = 0;
        for (int i = 0; i < n; ++i) {
            currentSum += nums[i];
            Integer idx = map.get(currentSum - target);
            if (idx != null && maxLen < (i - idx)) {
                maxLen = i - idx;
            }
            map.put(currentSum, i);
        }

        return n - maxLen;
    }
}