class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev2 = 0;
        int prev1 = nums[0];
        for(int idx = 1; idx < n; idx++) {
            int pick = nums[idx];
            if(idx > 1) {
                pick += prev2;
            }
            int notPick = prev1;
            int curr = Math.max(notPick, pick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}