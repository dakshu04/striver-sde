class Solution {
    //TC->O(N),SC->O(1)
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int ans1 = 1;
        int cnt = 0;
        Arrays.fill(ans, 0);
        for(int i : nums) {
            if(i == 0) cnt++;
            ans1 *= i;
        }
        if(cnt >= 2) return ans;
        else if(cnt == 1) {
            int temp = 1;
            int idx = -1;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != 0) {
                    temp = temp * nums[i];
                } else {
                    idx = i;
                }
            }
            ans[idx] = temp;
        }
        if(cnt == 0) {
            for(int i = 0; i < nums.length; i++) {
                ans[i] = ans1 / nums[i];
            }
        }
        return ans;
    }
}