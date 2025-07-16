class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1]; // dp[idx][prevIdx+1]

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
                int notPick = dp[idx + 1][prevIdx + 1];
                int pick = 0;
                if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
                    pick = 1 + dp[idx + 1][idx + 1];
                }
                dp[idx][prevIdx + 1] = Math.max(pick, notPick);
            }
        }

        return dp[0][0]; // start with idx = 0, prevIdx = -1 → shifted to 0
    }
}
