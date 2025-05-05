class Solution {
    //Optimization-TC->O(N), SC->O(1)
    public int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i - 2]
        int prev1 = 0; // dp[i - 1]

        for (int i = start; i <= end; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Exclude first house, rob from 1 to n-1
        int case1 = robLinear(nums, 1, n - 1);

        // Exclude last house, rob from 0 to n-2
        int case2 = robLinear(nums, 0, n - 2);

        return Math.max(case1, case2);
    }
}
