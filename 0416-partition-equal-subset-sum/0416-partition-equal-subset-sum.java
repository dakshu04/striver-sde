class Solution {
    public boolean fun(int idx, int target, int[] nums, int[][] dp) {
        if(target == 0) return true;
        if(idx == 0) return nums[idx] == target;
        if(dp[idx][target] != -1) return dp[idx][target] == 1;
        boolean notTake = fun(idx - 1, target, nums, dp);
        boolean take = false;
        if(target >= nums[idx]) {
            take = fun(idx - 1, target - nums[idx], nums, dp);
        }
        dp[idx][target] = (take || notTake) ? 1 : 0;
        return dp[idx][target] == 1;
    }
    public boolean canPartition(int[] nums) {
        //if the totalSum is odd -> cannot partitioned into two return false;
        int totalSum = 0;
        int n = nums.length; 
        for(int i = 0; i < n; i++) {
            totalSum += nums[i];
        }  
        int target = totalSum/2;
        int[][] dp = new int[n][target+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        if(totalSum % 2 != 0) return false;
        else {
            return fun(n-1, totalSum/2, nums, dp);
        }
    }
}