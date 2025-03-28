import java.util.*;

class Solution {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        // Base Case: First row is copied as it is
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Bottom-up DP filling
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j]; // Up
                int leftDiagonal = matrix[i][j] + (j > 0 ? dp[i - 1][j - 1] : (int) 1e9); // Left diagonal
                int rightDiagonal = matrix[i][j] + (j < m - 1 ? dp[i - 1][j + 1] : (int) 1e9); // Right diagonal

                // Take minimum of all possible paths
                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // Find the minimum in the last row
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }

        return minSum;
    }

}
