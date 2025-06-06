class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxSum = nums[0];
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}