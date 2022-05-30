/**
 * @URL: https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/
 */

public class CheckIfNumberHasEqualDigitCountAndDigitValue {
    /**
     * Time : O(n)
     * Space: O(1)
     */
    public boolean digitCount(String num) {
        int[] count = new int[10];
        int n = num.length();

        for (char ch : num.toCharArray()) {
            ++count[ch - '0'];
        }

        for (int i = 0; i < n; ++i) {
            if (count[i] != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }
}