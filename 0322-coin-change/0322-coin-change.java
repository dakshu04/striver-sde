class Solution {
    public int fun(int idx, int[] coins, int amount, int[][] dp) {
        if(idx == 0) {
            if(amount % coins[idx] == 0) {
                return amount / coins[0];
            } else {
                return (int)1e9;
            }
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int notTake = fun(idx - 1, coins, amount, dp);
        int take = Integer.MAX_VALUE;
        if(amount >= coins[idx]) {
            take = 1 + fun(idx, coins, amount - coins[idx], dp);
        }
        return dp[idx][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = fun(n-1, coins, amount, dp);
        return ans == (int)1e9 ? -1 : ans;
    }
}