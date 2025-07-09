class Solution {
    public int climbStairHeler(int idx, int[] dp) {
        if(idx == 0 || idx == 1) return 1;
        if(dp[idx] != -1) return dp[idx];
        int left = climbStairHeler(idx - 1, dp);
        int right = climbStairHeler(idx - 2, dp);
        return dp[idx] = left + right;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairHeler(n, dp);  
    }
}