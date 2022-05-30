/**
 * @URL: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/ 
 */

public class NumberOfStepsToReduceANumberToZero {
    /**
     * Time : O(log(n))
     * Space: O(1)
     */
    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }

        int steps = 0;
        while (num != 0) {
            // If num is even number, it requires 1 step other wise it requires 2 step to reach near to 0
            steps += 1 + (num & 1);
            num >>= 1;
        }

        // For n == 1, 2 steps are added so we need to reduce 1 from the final answer.
        // Due to this we need to handle the special case of 0, otherwise the answer will be returned -1 in case of 0.
        return steps - 1;
    }
}