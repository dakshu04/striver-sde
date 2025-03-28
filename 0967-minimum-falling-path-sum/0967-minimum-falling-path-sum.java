class Solution {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m]; // Store previous row results
        // Base Case: First row is copied as it is
        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + prev[j]; // Up
                int leftDiagonal = matrix[i][j] + (j > 0 ? prev[j - 1] : (int) 1e9);
                int rightDiagonal = matrix[i][j] + (j < m - 1 ? prev[j + 1] : (int) 1e9);

                curr[j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
            prev = curr; // Update previous row
        }
        // Find the minimum in the last row
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minSum = Math.min(minSum, prev[j]);
        }
        return minSum;
    }
}
