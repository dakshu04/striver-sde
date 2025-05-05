class Solution {
    //TC->O(N), SC->O(N)
    public int robLinear(int[] nums, int start, int end) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[start] = nums[start];
        if (start + 1 <= end)
            dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[end];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int case1 = robLinear(nums, 0, n - 2); // Exclude last house
        int case2 = robLinear(nums, 1, n - 1); // Exclude first house

        return Math.max(case1, case2);
    }
}
