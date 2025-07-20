class Solution {
    public int fun(int idx1, int idx2, String word1, String word2, int[][] dp) {
        if(idx1 < 0) {
            return idx2 + 1;
        }
        if(idx2 < 0) {
            return idx1 + 1;
        }
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if(word1.charAt(idx1) == word2.charAt(idx2)) {
            return fun(idx1 - 1, idx2 - 1, word1, word2, dp);
        } else {
            int insert = 1 + fun(idx1, idx2-1, word1, word2, dp);
            int delete = 1 + fun(idx1-1, idx2, word1, word2, dp);
            int replace = 1 + fun(idx1-1, idx2-1, word1, word2, dp);
            return dp[idx1][idx2] = Math.min(insert, Math.min(delete, replace));
        }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fun(n-1, m-1, word1, word2, dp);
    }
}