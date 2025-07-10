class Solution {
    public int fun(int[] coins, int target, int idx, int[][] dp) {
        if(idx == 0) {
            if(target % coins[0] == 0) {
                return target / coins[0];
            } else {
                return (int)1e9;
            }
        }
        if(dp[idx][target] != -1) return dp[idx][target];
        int notTake = fun(coins, target, idx - 1, dp);
        int take = (int) 1e9;
        if(target >= coins[idx]) {
            take = fun(coins, target - coins[idx], idx, dp) + 1;
        }
        return dp[idx][target] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int res = fun(coins, amount, n - 1, dp);
        return res >= (int)1e9 ? -1 : res;
    }
}