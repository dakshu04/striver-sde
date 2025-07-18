class Solution {
    public int fun(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        int n = triangle.size();
        if(i == n - 1) return triangle.get(i).get(j); // base case: bottom row
        if(dp[i][j] != -1) return dp[i][j];
        int down = fun(i + 1, j, triangle, dp);
        int diagonal = fun(i + 1, j + 1, triangle, dp);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n]; // triangle has at most n columns in last row
        for (int[] row : dp) Arrays.fill(row, -1);
        return fun(0, 0, triangle, dp); // start from top
    }
}
