class Solution {
    public int fun(int idx, int target, int[] coins, int[][] dp) {
        if(target == 0) return 1;
        if(idx == 0) {
            return (target % coins[idx] == 0) ? 1 : 0;
        }
        if(dp[idx][target] != -1) return dp[idx][target];
        int notTake = fun(idx - 1, target, coins, dp);
        int take = 0;
        if(target >= coins[idx]) {
            take = fun(idx, target - coins[idx], coins, dp);
        }
        return dp[idx][target] = take + notTake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fun(n-1, amount, coins, dp);
    }
}