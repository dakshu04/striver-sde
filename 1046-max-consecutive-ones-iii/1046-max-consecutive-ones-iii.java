class Solution {
    public int longestOnes(int[] nums, int k) {//Tc-O(n)
        int n = nums.length;
        int maxLen = 0;
        int zeroCnt = 0;
        int left = 0;
        int right = 0;
        while(right < n) {
            if(nums[right] == 0) {
                zeroCnt++;
            }
            if(zeroCnt > k) {
                if(nums[left] == 0) {
                    zeroCnt--;
                }
                left++;
            }
            

            if(zeroCnt <= k) {
                int len = right-left+1;
                maxLen = Math.max(len, maxLen);
            }
            
            right++;
        }
        return maxLen;
    }
}