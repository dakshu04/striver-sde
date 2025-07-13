class Solution {
    public int minPathSumHelper(int idx1, int idx2, int[][] grid, int[][] dp) {
        if(idx1 < 0 || idx2 < 0) return Integer.MAX_VALUE;
        if(idx1 == 0 && idx2 == 0) return grid[idx1][idx2];
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int top = minPathSumHelper(idx1 - 1, idx2, grid, dp);
        int left = minPathSumHelper(idx1, idx2 - 1, grid, dp);
        return  dp[idx1][idx2] = grid[idx1][idx2] + Math.min(top, left);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minPathSumHelper(n-1, m-1, grid, dp);
    }
}