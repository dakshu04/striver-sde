class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n + 1]; // +1 to handle -1 prev_index
        return helper(0, -1, nums, dp);
    }

    private int helper(int index, int prevIndex, int[] nums, Integer[][] dp) {
        if (index == nums.length) return 0;

        if (dp[index][prevIndex + 1] != null) return dp[index][prevIndex + 1];

        // Not take current element
        int notTake = helper(index + 1, prevIndex, nums, dp);

        // Take current element if it is greater than previous
        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + helper(index + 1, index, nums, dp);
        }

        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }
}
