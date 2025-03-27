class Solution {
    public int uniquePaths(int m, int n) {
        // Create a DP table of size m x n
        int[][] dp = new int[m][n];
        //TC->O(m × n) SC-> O(m × n)
        // Base case: The first row and first column should all be 1
        // because there's only one way to reach any of those cells (either moving right or down).
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // Fill the DP table iteratively
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Sum of paths from top and left
            }
        }

        return dp[m - 1][n - 1]; // Return the value at the bottom-right cell
    }
}