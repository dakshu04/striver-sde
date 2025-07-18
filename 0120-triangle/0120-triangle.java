class Solution {
    public int fun(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        if (j < 0 || j > i) return (int) 1e9; // out of bounds
        if (i == 0 && j == 0) return triangle.get(0).get(0);
        if (dp[i][j] != -1) return dp[i][j];
        int up = fun(i - 1, j, triangle, dp);     // same index from above row
        int upLeft = fun(i - 1, j - 1, triangle, dp); // left diagonal
        return dp[i][j] = triangle.get(i).get(j) + Math.min(up, upLeft);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int minPath = (int) 1e9;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        // Try all paths from last row to (0, 0)
        for (int j = 0; j < n; j++) {
            minPath = Math.min(minPath, fun(n - 1, j, triangle, dp));
        }
        return minPath;
    }
}
