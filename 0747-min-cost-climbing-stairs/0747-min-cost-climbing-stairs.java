class Solution {
    //TC->O(n), SC->O(n) - Memoization
    public int dfs(int[] cost, int idx, int[] dp) {
        if(idx == 0) return cost[0]; //can start with both 0 or 1
        if(idx == 1) return cost[1]; //can start with both 0 or 1
        if(dp[idx] != -1) return dp[idx];
        int left = cost[idx] + dfs(cost, idx - 1, dp);
        int right = cost[idx] + dfs(cost, idx - 2, dp);
        return dp[idx] = Math.min(left, right);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(dfs(cost, n - 1, dp), dfs(cost, n - 2, dp));
    }
}