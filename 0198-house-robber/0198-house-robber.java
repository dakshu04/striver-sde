class Solution {
    public int fn(int[] nums, int idx, int[] dp) {
        if (idx == 0) return nums[0];
        if (idx == 1) return Math.max(nums[0], nums[1]);
        if (dp[idx] != -1) return dp[idx];

        int skip = fn(nums, idx - 1, dp);           // Skip current
        int take = nums[idx] + fn(nums, idx - 2, dp); // Rob current

        return dp[idx] = Math.max(skip, take);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return fn(nums, n - 1, dp);
    }
}
