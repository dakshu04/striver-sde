class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countWays(coins, n - 1, amount, dp);
    }
    private int countWays(int[] coins, int idx, int amount, int[][] dp) {
        if (amount == 0) return 1; // ✅ One valid way: choose nothing
        
        if (idx == 0) {
            // ✅ Check if amount can be made with only the 0th coin
            return (amount % coins[0] == 0) ? 1 : 0;
        }
        if (dp[idx][amount] != -1) return dp[idx][amount];
        int notTake = countWays(coins, idx - 1, amount, dp);
        int take = 0;
        if (coins[idx] <= amount) {
            take = countWays(coins, idx, amount - coins[idx], dp);
        }
        return dp[idx][amount] = take + notTake;
    }
}
