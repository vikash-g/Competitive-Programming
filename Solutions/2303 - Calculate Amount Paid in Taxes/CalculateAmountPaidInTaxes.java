/**
 * @URL: https://leetcode.com/problems/calculate-amount-paid-in-taxes/
 */

public class CalculateAmountPaidInTaxes {
    /**
     * Time : O(n)
     * Space: O(1)
     */
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int prev = 0;
        for (int[] b : brackets) {
            tax += (Math.min(income, b[0]) - prev) * b[1] / 100.0;
            if (income <= b[0]) {
                break;
            }
            prev = b[0];
        }
        return tax;
    }
}