/**
 * @URL: https://leetcode.com/problems/find-the-highest-altitude/
 */

public class FindTheHighestAltitude {
    /**
     * Time : O(n)
     * Space: O(1)
     */
    public int largestAltitude(int[] gain) {
        int highestAltitude = gain[0];
        int n = gain.length;
        for (int i = 1; i < n; ++i) {
            gain[i] += gain[i - 1];
            highestAltitude = Math.max(highestAltitude, gain[i]);
        }
        return Math.max(0, highestAltitude);
    }
}
