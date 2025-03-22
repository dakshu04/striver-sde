class Solution {
    private void dfs(int i, int j, int n, int m, char[][] grid) {
        if(i < 0 || i >= n || j < 0 || j >= m) {
            return;
            }
        if(grid[i][j] == '1') {
            grid[i][j] = '#';
            dfs(i - 1, j, n, m, grid);
            dfs(i, j + 1, n, m, grid);
            dfs(i + 1, j, n, m, grid);
            dfs(i, j - 1, n, m, grid);
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j, n, m, grid);
                    ans++;
                }
            }
        }
        return ans;
    }
}