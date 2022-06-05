/**
 * @URL: https://leetcode.com/problems/n-queens-ii/submissions/
 */

public class NQueensII {
    private int ans;

    /**
     * Time : O(n^n)
     * Space: O(n)
     */
    public int totalNQueens(int n) {
        ans = 0;
        backtrack(n, new boolean[n], new boolean[n << 1], new boolean[n << 1], 0);
        return ans;
    }

    private void backtrack(int n, boolean[] cols, boolean[] diag1, boolean[] diag2, int row) {
        if (row == n) {
            ++ans;
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (!cols[i] && !diag1[row + i] && !diag2[row + n - i]) {
                cols[i] = diag1[row + i] = diag2[row + n - i] = true;
                backtrack(n, cols, diag1, diag2, row + 1);
                cols[i] = diag1[row + i] = diag2[row + n - i] = false;
            }
        }
    }
}