class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxAns = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int prod = 1;
            for(int j = i; j < n; j++) {
                prod *= nums[j];
                maxAns = Math.max(maxAns, prod);
            }
        }
        return maxAns;
    }
}