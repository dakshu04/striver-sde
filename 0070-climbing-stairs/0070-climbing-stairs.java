class Solution {
    public int helper(int n, int[] dp) {
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) {
            return dp[n];
        }
        int prev = helper(n - 1, dp);
        int prev2 = helper(n - 2, dp);
        dp[n] = prev + prev2;
        return dp[n];
    }
    public int climbStairs(int n) {
        // if(n == 0 || n == 1) {//TC->O(2^n)
        //     return 1;
        // }
        // int left = climbStairs(n - 1);
        // int right = climbStairs(n - 2);
        // return left + right;

        //Memoization-TC->O(n),SC->O(n)
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
}