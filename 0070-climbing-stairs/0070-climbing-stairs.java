class Solution {
    public int fun(int idx, int[] dp) {
        if(idx == 0) return 1;
        if(idx == 1) return 1;
        if(dp[idx] != -1) return dp[idx];
        int oneStep = fun(idx-1, dp);
        int twoStep = fun(idx-2, dp);
        return dp[idx] = oneStep+twoStep;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fun(n, dp);
    }
}