/**
 * @URL: https://leetcode.com/problems/transpose-matrix/solution/
 */

public class TransposeMatrix {
    /**
     * Time : O(m * n)
     * Space: O(1), We don't count space required for the output matrix.
     */
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] tMatrix = new int[n][m];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                tMatrix[j][i] = matrix[i][j];
            }
        }

        return tMatrix;
    }
}
