/**
 * @URL: https://leetcode.com/problems/maximum-product-of-word-lengths/
 */

// Time : O(n^2)
// Space: O(n)
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int ans = 0;
        int[] bitArr = new int[n];

        for (int i = 0; i < n; ++i) {
            int mask = 0;
            for (char ch : words[i].toCharArray()) {
                mask |= 1 << (ch - 'a');
            }
            bitArr[i] = mask;

            int maxJLen = 0;
            for (int j = 0; j < i; ++j) {
                if ((bitArr[j] & mask) == 0 && maxJLen < words[j].length()) {
                    maxJLen = words[j].length();
                }
            }
            ans = Math.max(ans, maxJLen * words[i].length());
        }

        return ans;
    }
}
