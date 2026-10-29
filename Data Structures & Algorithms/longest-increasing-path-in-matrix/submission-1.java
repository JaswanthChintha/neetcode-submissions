class Solution {
int max = 0;

public int longestIncreasingPath(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            max = Math.max(max, dfs(matrix, i, j, dp));
        }
    }

    return max;
}

public int dfs(int[][] matrix, int i, int j, int[][] dp) {
    if (dp[i][j] != 0) {
        return dp[i][j];
    }

    int m = matrix.length;
    int n = matrix[0].length;

    int len = 1;

    if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
        len = Math.max(len, 1 + dfs(matrix, i - 1, j, dp));
    }

    if (i < m - 1 && matrix[i + 1][j] > matrix[i][j]) {
        len = Math.max(len, 1 + dfs(matrix, i + 1, j, dp));
    }

    if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
        len = Math.max(len, 1 + dfs(matrix, i, j - 1, dp));
    }

    if (j < n - 1 && matrix[i][j + 1] > matrix[i][j]) {
        len = Math.max(len, 1 + dfs(matrix, i, j + 1, dp));
    }

    dp[i][j] = len;
    return len;
}

}