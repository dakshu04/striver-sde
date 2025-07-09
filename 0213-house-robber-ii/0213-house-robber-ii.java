class Solution {
    private int robLinear(int[] nums, int idx, int start, int[] dp) {
        if (idx == start) return nums[start];
        if (idx == start + 1) return Math.max(nums[start], nums[start + 1]);
        if (dp[idx] != -1) return dp[idx];
        int skip = robLinear(nums, idx - 1, start, dp);
        int take = nums[idx] + robLinear(nums, idx - 2, start, dp);
        return dp[idx] = Math.max(skip, take);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int case1 = robLinear(nums, n - 2, 0, dp1); // exclude last
        int case2 = robLinear(nums, n - 1, 1, dp2); // exclude first
        return Math.max(case1, case2);
    }
}
