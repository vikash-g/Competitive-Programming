/**
 * @URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Time : O(n)
     * Space: O(1), Space required to keep the last index of each unique character is constant.
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] lastIndexMap = new int[256];
        Arrays.fill(lastIndexMap, -1);

        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < n; ++i) {
            if (lastIndexMap[arr[i]] >= start) {
                maxLength = Math.max(maxLength, i - start);
                start = lastIndexMap[arr[i]] + 1;
            }
            lastIndexMap[arr[i]] = i;
        }

        return Math.max(maxLength, n - start);
    }
}