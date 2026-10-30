class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        int[] cols = new int[n];
        solve(0, n, cols);
        return count;
    }

    public void solve(int row, int n, int[] cols) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, cols)) {
                cols[row] = col;
                solve(row + 1, n, cols);
            }
        }
    }

    public boolean isSafe(int row, int col, int[] cols) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == col ||
                Math.abs(cols[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }

        return true;
    }
}