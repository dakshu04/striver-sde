class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //TC->O(n^2){nested loop}
        //SC->O(n^2){dp size}
        int[][] dp = new int[n + 1][n + 1];
        for(int idx = n - 1; idx >= 0; idx--) {
            for(int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
                int len = dp[idx + 1][prevIdx + 1];
                int take = 0;
                if(prevIdx == -1 || nums[prevIdx] < nums[idx]) {
                    len = Math.max(len, 1 + dp[idx + 1][idx + 1]);
                }
                dp[idx][prevIdx + 1] = len;
            }
        }
        return dp[0][-1 + 1];
    }
}