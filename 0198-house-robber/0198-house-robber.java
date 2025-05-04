class Solution {
    // TC -> O(n), SC -> O(1) {dp} {Optimization}
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;  // No houses, no money
        if (n == 1) return nums[0];  // Only one house, rob it
        
        // Initialize for the first two houses
        int prev1 = nums[0];  // Max money robbed up to the first house
        int prev2 = Math.max(nums[0], nums[1]);  // Max money robbed from the first two houses

        // Start from the third house
        for (int i = 2; i < n; i++) {
            int currTaken = nums[i] + prev1;  // Rob the current house and add it to the money robbed two houses ago
            int currSkip = prev2;  // Skip the current house, so take the value of the previous house
            
            int temp = Math.max(currTaken, currSkip);  // Choose the max between robbing or skipping the current house
            prev1 = prev2;  // Move prev1 to prev2
            prev2 = temp;   // Update prev2 with the max value
        }
        
        return prev2;  // The answer will be in prev2 (max money robbed from all houses)
    }
}
