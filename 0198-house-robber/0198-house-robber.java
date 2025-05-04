class Solution {
    //TC->O(n), SC->O(n){Recursion + dp}
    public int dfs(int idx, int[] nums, int[] dp) {
        if(idx < 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int robCurr = nums[idx] + dfs(idx - 2, nums, dp);
        int skipCurr = dfs(idx - 1, nums, dp);
        return dp[idx] = Math.max(robCurr, skipCurr);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(n - 1, nums, dp);
    }
}