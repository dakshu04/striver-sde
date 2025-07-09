class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int idx = 2; idx < n; idx++) {
            dp[idx] = cost[idx] + Math.min(dp[idx-1], dp[idx-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}
