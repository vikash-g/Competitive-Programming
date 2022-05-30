/**
 * @URL: https://leetcode.com/problems/divide-two-integers/
 */

class DivideTwoIntegers {
    /**
     * Time : O(log(n))
     * Space: O(1)
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }

        boolean isNegative = (dividend > 0) != (divisor > 0);
        int power = 31;
        int ans = 0;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (dividend - divisor >= 0) {
            if ((dividend >>> power) - divisor >= 0) {
                ans += 1 << power;
                dividend -= divisor << power;
            }
            --power;
        }

        return isNegative ? -ans : ans;
    }
}