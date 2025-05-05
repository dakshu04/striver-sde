class Solution {
    //TC->O(N), SC->O(N)(Memo)
    public int dfs(int start, int end, int[] nums, int[] dp) {
        if(start > end) return 0;
        if(dp[start] != -1) return dp[start];
        int pick = nums[start] + dfs(start + 2, end, nums, dp);
        int notPick = dfs(start + 1, end, nums, dp);
        return dp[start] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(dfs(1, n - 1, nums, dp1), dfs(0, n - 2, nums, dp2));
    }
}