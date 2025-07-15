class Solution {
    public boolean fun(int i, int j, String s, String p, int[][] dp) {
        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) return false;
        if (i < 0 && j >= 0) {
            for (int jj = 0; jj <= j; jj++) {
                if (p.charAt(jj) != '*') return false;
            }
            return true;
        }
        if (dp[i][j] != -1) return dp[i][j] == 1;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = fun(i - 1, j - 1, s, p, dp) ? 1 : 0;
        } else if (p.charAt(j) == '*') {
            dp[i][j] = (fun(i - 1, j, s, p, dp) || fun(i, j - 1, s, p, dp)) ? 1 : 0;
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j] == 1;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return fun(n - 1, m - 1, s, p, dp);
    }
}
