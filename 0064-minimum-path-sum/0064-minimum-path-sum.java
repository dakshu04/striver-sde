class Solution {
    public int f(int i, int j, int[][] grid) {
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return Integer.MAX_VALUE; //maxValue so ans would not include it as it is asking for minValue
        int up = i > 0 ? grid[i][j] + f(i - 1, j, grid) : Integer.MAX_VALUE;
        int left = j > 0 ? grid[i][j] + f(i, j - 1, grid) : Integer.MAX_VALUE;
        return Math.min(up, left);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return f(n - 1, m - 1, grid);
    }
}