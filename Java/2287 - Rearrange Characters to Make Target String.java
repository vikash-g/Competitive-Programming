/**
 * @URL: https://leetcode.com/problems/rearrange-characters-to-make-target-string/
 */

 // Time : O(n), where n is s.length().
 // Space: O(1)
class Solution {
    public int rearrangeCharacters(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];

        for (char ch : s.toCharArray()) {
            ++sCount[ch - 'a'];
        }
        for (char ch : t.toCharArray()) {
            ++tCount[ch - 'a'];
        }
        int answer = 101;
        for (int i = 0; i < 26; ++i) {
            if (tCount[i] > 0) {
                answer = Math.min(answer, sCount[i] / tCount[i]);
            }
        }
        return answer;
    }
}