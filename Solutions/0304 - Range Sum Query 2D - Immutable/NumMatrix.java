/**
 * @URL: https://leetcode.com/problems/range-sum-query-2d-immutable/
 */

public class NumMatrix {
    /**
     * Time : O(m * n)
     * Space: O(1)
     */
    private int[][] mat;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        mat = matrix;

        for (int j = 1; j < n; ++j) {
            mat[0][j] += mat[0][j - 1];
        }

        for (int i = 1; i < m; ++i) {
            mat[i][0] += mat[i - 1][0];
            for (int j = 1; j < n; ++j) {
                mat[i][j] += mat[i - 1][j] + mat[i][j - 1] - mat[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {        
        if (row1 > 0 && col1 > 0) {
            return mat[row2][col2] - (mat[row1 - 1][col2] + mat[row2][col1 - 1]) + mat[row1 - 1][col1 - 1];
        }
        if (row1 > 0) {
            return mat[row2][col2] - mat[row1 - 1][col2];
        } else if (col1 > 0) {
            return mat[row2][col2] - mat[row2][col1 - 1];
        }
        return mat[row2][col2];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
