class Solution {
    public int dfs(int row, int col, int[][] grid) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        int area = 1;
        // expolore all 4 directions
        area += dfs(row, col + 1, grid);
        area += dfs(row + 1, col, grid);
        area += dfs(row - 1, col, grid);
        area += dfs(row, col - 1, grid);
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    int area = dfs(i, j, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}