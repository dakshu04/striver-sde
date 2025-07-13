class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // Create DP table
        int[][] dp = new int[n][m];
        // Base case: first row of dp is same as matrix
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }
        // Fill the dp table row by row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = dp[i - 1][j];
                int leftDia = (j > 0) ? dp[i - 1][j - 1] : (int) 1e9;
                int rightDia = (j < m - 1) ? dp[i - 1][j + 1] : (int) 1e9;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(leftDia, rightDia));
            }
        }
        // Answer is the min of the last row
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }
        return mini;
    }
}
