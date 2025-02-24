class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right  = nums.length - 1;
        //Edge Case of only 1 length of nums
        if(nums.length == 1) {
            return nums[0];
        }
        //[1,1,2] - Edge Case 2       
        if(nums[n-1] != nums[n-2]) {
            return nums[n-1];
        }
        //[1,2,2,3,3] - Edge Case 3
        if(nums[0] != nums[1]) {
            return nums[0];
        }
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            if((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}