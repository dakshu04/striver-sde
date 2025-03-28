class Solution {//TC->O(n*m),SC->O(n*m), No rec tech stack
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        // Fill the dp table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j]; // Base case (starting cell)
                else {
                    int up = (i > 0) ? dp[i - 1][j] : (int) 1e9; // Value from top cell
                    int left = (j > 0) ? dp[i][j - 1] : (int) 1e9; // Value from left cell
                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[n - 1][m - 1]; // Final answer at the bottom-right cell
    }
}
