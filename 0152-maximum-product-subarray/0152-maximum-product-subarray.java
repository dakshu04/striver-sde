class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxAns = Integer.MIN_VALUE;
        int prefixSum = 1;
        int suffixSum = 1;
        for(int i = 0; i < n; i++) {
            if(prefixSum == 0) prefixSum = 1;
            if(suffixSum == 0) suffixSum = 1;
            prefixSum *= nums[i];
            suffixSum *= nums[n-i-1];
            maxAns = Math.max(maxAns, Math.max(prefixSum, suffixSum));
        }
        return maxAns;
    }
}