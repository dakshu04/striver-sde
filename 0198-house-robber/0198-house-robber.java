class Solution {
    public int robHelper(int[] nums, int idx, int[] dp) {
        if(idx < 0) return 0; 
        if(dp[idx] != -1) return dp[idx];
        int skipCurr = robHelper(nums, idx - 1, dp);
        int curr = nums[idx] + robHelper(nums, idx - 2, dp);
        return dp[idx] = Math.max(skipCurr, curr);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return robHelper(nums, n-1, dp);
    }
}
