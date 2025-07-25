class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            int skipCurr = dp[i-1];
            int curr = nums[i] + dp[i-2];
            dp[i] = Math.max(skipCurr, curr);
        }
        return dp[n-1];
    }
}
