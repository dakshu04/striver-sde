class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }//TC->O(n^2),SC->O(n^2)
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev_ind = ind - 1; prev_ind >= -1; prev_ind--) {
                int len = 0 + dp[ind + 1][prev_ind + 1];
                if (prev_ind == -1 || arr[ind] > arr[prev_ind]) {
                    len = Math.max(len, 1 + dp[ind + 1][ind + 1]);
                }
                dp[ind][prev_ind + 1] = len;
            }
        }
        return dp[0][0];
    }

}
