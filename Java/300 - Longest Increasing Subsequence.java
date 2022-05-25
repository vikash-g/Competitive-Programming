
/**
 * @URL: https://leetcode.com/problems/longest-increasing-subsequence/
 */

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(sol.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        System.out.println(sol.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(sol.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

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
