/**
 * @URL: https://leetcode.com/problems/russian-doll-envelopes/
 */

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(sol.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
    }

    public int maxEnvelopes(int[][] envelopes) {
        // Sort based on increasing width. When widths are same, sort based on decreasing height (why?).
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]));

        // As the widths are already in increasing order, find longest increasing subsequence (LIS) based on heights.
        int[] dp = new int[envelopes.length];
        int len = 0;

        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0) {
                index = -(index + 1);
            }

            dp[index] = envelope[1];

            if (index == len) {
                ++len;
            }
        }

        return len;
    }
}
