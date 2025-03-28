class Solution {//TC->O(n*m),SC->O(1)
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] prev = new int[m]; // Stores previous row results
        for (int i = 0; i < n; i++) {
            int[] curr = new int[m]; // Current row being computed
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) curr[j] = grid[i][j]; // Base case
                else {
                    int up = (i > 0) ? prev[j] : (int) 1e9; // Value from the row above
                    int left = (j > 0) ? curr[j - 1] : (int) 1e9; // Value from left cell
                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = curr; // Update prev row to the current row
        }
        return prev[m - 1]; // Answer is in the last column of the last processed row
    }
}
