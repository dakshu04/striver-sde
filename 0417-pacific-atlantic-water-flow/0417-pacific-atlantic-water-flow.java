class Solution {
    // Directions: up, right, down, left
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        // visited arrays for Pacific and Atlantic
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        // DFS from all Pacific border cells (top row and left column)
        for (int i = 0; i < n; i++) {
            dfs(i, 0, heights, pacific, heights[i][0]);
        }
        for (int j = 0; j < m; j++) {
            dfs(0, j, heights, pacific, heights[0][j]);
        }
        // DFS from all Atlantic border cells (bottom row and right column)
        for (int i = 0; i < n; i++) {
            dfs(i, m - 1, heights, atlantic, heights[i][m - 1]);
        }
        for (int j = 0; j < m; j++) {
            dfs(n - 1, j, heights, atlantic, heights[n - 1][j]);
        }
        // Collecting cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    // DFS function to mark reachable cells
    private void dfs(int row, int col, int[][] heights, boolean[][] visited, int prevHeight) {
        int n = heights.length;
        int m = heights[0].length;
        // Base conditions: out of bounds, already visited, or height condition violated
        if (row < 0 || col < 0 || row >= n || col >= m || visited[row][col] || heights[row][col] < prevHeight) {
            return;
        }
        // Mark current cell as visited
        visited[row][col] = true;
        // Move in 4 directions
        for (int d = 0; d < 4; d++) {
            int newRow = row + dx[d];
            int newCol = col + dy[d];
            dfs(newRow, newCol, heights, visited, heights[row][col]);
        }
    }
}
