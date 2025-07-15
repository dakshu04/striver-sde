class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2]; // dp[i][buy]: max profit from day i with state "buy"
        // Base case already 0: dp[n][0] = 0, dp[n][1] = 0
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    dp[ind][buy] = Math.max(
                        dp[ind + 1][0],                   // skip
                        -prices[ind] + dp[ind + 1][1]     // buy
                    );
                } else {
                    dp[ind][buy] = Math.max(
                        dp[ind + 1][1],                   // skip
                        prices[ind] + dp[ind + 1][0]      // sell
                    );
                }
            }
        }
        return dp[0][0]; // Start from day 0 with permission to buy
    }
}
