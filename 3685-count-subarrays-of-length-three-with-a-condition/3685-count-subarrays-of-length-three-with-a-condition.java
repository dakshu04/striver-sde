class Solution {
    public int countSubarrays(int[] nums) {
        int windowSize = 3;
        int left = 0;
        int cnt = 0;
        for(int right = 0; right < nums.length; right++) {
            if(right-left+1 == windowSize) {
                if ((nums[left] + nums[right]) == (float)(nums[left + 1] / 2.0)) {
                    cnt++;
                }
                // Move the left pointer to shrink the window from the left
                left++;
            } 
        }
        return cnt;
    }
}