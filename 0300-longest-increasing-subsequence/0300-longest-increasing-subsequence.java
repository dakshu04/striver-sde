class Solution {//TC->O(n^2){checks max of two recursive call and checks if(it is already calculated)}, Sc->O(n^2)
    public int helperFn(int idx, int prevIdx, int[] nums, int[][] dp) {
        if(idx == nums.length) return 0;
        if(dp[idx][prevIdx + 1] != -1) return dp[idx][prevIdx + 1];
        //notTake
        int notTake = 0 + helperFn(idx + 1, prevIdx, nums, dp);
        //take
        int take = 0;
        if(prevIdx == -1 || nums[prevIdx] < nums[idx]) {
            take = 1 + helperFn(idx + 1, idx, nums, dp);
        }
        return dp[idx][prevIdx + 1] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helperFn(0, -1, nums, dp);
    }
}