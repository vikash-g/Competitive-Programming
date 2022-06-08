/**
 * @URL: https://leetcode.com/problems/remove-palindromic-subsequences/
 */

public class RemovePalindromicSubsequences {
    /**
     * Time : O(n)
     * Space: O(1)
     */
    public int removePalindromeSub(String s) {
        // If the whole string is palindrome we just need 1 step.
        // Otherwise we can remove subsequence containing all 'a' in 1st step
        // and then all 'b' will be remaining which can be removed in 2nd step.
        return isPalindrome(s.toCharArray()) ? 1 : 2;
    }

    private boolean isPalindrome(char[] str) {
        int left = 0;
        int right = str.length - 1;
        while (left < right) {
            if (str[left++] != str[right--]) {
                return false;
            }
        }
        return true;
    }
 }