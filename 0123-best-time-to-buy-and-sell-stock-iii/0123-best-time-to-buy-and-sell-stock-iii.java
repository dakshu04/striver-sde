class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[ind][buy][cap]
        int[][][] dp = new int[n][2][3]; // max 2 transactions allowed → cap ∈ [0,2]
        // Initialize with -1
        for (int[][] day : dp)
            for (int[] b : day)
                Arrays.fill(b, -1);

        return helper(0, 1, 2, prices, dp); // Start at day 0, allowed to buy, 2 transactions remaining
    }
    private int helper(int ind, int buy, int cap, int[] prices, int[][][] dp) {
        if (ind == prices.length || cap == 0) return 0;
        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];
        int profit = 0;
        if (buy == 1) {
            // Option 1: buy stock
            // Option 2: skip
            profit = Math.max(
                -prices[ind] + helper(ind + 1, 0, cap, prices, dp),  // buy
                helper(ind + 1, 1, cap, prices, dp)                  // skip
            );
        } else {
            // Option 1: sell stock → reduce cap by 1
            // Option 2: skip
            profit = Math.max(
                prices[ind] + helper(ind + 1, 1, cap - 1, prices, dp), // sell
                helper(ind + 1, 0, cap, prices, dp)                    // skip
            );
        }
        dp[ind][buy][cap] = profit;
        return profit;
    }
}
