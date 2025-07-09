class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int idx = 2; idx < n; idx++) {
            dp[idx] = Math.max(dp[idx - 1], nums[idx] + dp[idx - 2]);
        }

        return dp[n - 1];
    }
}
