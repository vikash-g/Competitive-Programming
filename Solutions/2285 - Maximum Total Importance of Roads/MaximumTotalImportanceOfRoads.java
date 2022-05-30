/**
 * @URL: https://leetcode.com/problems/maximum-total-importance-of-roads/
 */

public class MaximumTotalImportanceOfRoads {
    /**
     * Time : O(nlog(n))
     * Space: O(n)
     */
    public long maximumImportance(int n, int[][] roads) {
        // Find with how many roads a city is connected.
        int[] degrees = new int[n];
        for(int[] r : roads){
            ++degrees[r[0]];
            ++degrees[r[1]];
        }
        Arrays.sort(degrees);

        // Assign importance to city based on number of roads its connected. 
        long res = 0;
        for (int i = 0; i < n; ++i) {
            res += (long) degrees[i] * (i + 1);
        }
        return res;
    }
}