/**
 * @URL: https://leetcode.com/problems/longest-valid-parentheses/
 */

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(""));
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses(")()())"));
        System.out.println(solution.longestValidParentheses("((()))()()())))(((()))))))(((())()()()))))(((((())))()()))()))(())))(((()))))))"));
    }

    public int longestValidParentheses(String s) {
        int n = s.length();
        int maxLen = 0;
        int count = 0;
        for (int i = 0, start  = 0; i < n; ++i) {
            count += s.charAt(i) == '(' ? 1 : -1;
            if (count == 0) {
                maxLen = Math.max(maxLen, i - start + 1);
            } else if (count < 0) {
                count = 0;
                start = i + 1;
            }
        }

        count = 0;
        for (int i = n - 1, start = n - 1; i >= 0; --i) {
            count += s.charAt(i) == ')' ? 1 : -1;
            if (count == 0) {
                maxLen = Math.max(maxLen, start - i + 1);
            } else if (count < 0) {
                count = 0;
                start = i - 1;
            }
        }

        return maxLen;
    }
}