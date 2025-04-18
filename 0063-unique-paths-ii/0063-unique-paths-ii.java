class Solution {
    public int f(int i, int j, int[][] obstacleGrid, int[][] dp) {
        // If starting cell is blocked, no paths exist
        if (obstacleGrid[0][0] == 1) return 0;
        // If the current cell is an obstacle, return 0 paths
        if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) {
            return 0;
        }
        // Base case: If we reach the starting cell, count one valid path
        if (i == 0 && j == 0) {
            return 1;
        }
        // If indices go out of bounds, return 0
        if (i < 0 || j < 0) {
            return 0;
        }
        // If result is already computed, return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // Compute paths from left and up cells
        int left = f(i, j - 1, obstacleGrid, dp);
        int up = f(i - 1, j, obstacleGrid, dp);
        // Store and return result
        return dp[i][j] = up + left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        // Initialize DP table with -1
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, m - 1, obstacleGrid, dp);
    }
}