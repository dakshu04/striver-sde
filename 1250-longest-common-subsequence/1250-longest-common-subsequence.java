class Solution {
    public int fun(int idx1, int idx2, String text1, String text2, int[][] dp) {
        if(idx1 < 0 || idx2 < 0) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if(text1.charAt(idx1) == text2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + fun(idx1-1, idx2-1, text1, text2, dp);
        } else {
            return dp[idx1][idx2] = Math.max(fun(idx1, idx2-1, text1, text2, dp), fun(idx1-1, idx2, text1, text2, dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fun(n-1, m-1, text1, text2, dp);
    }
}