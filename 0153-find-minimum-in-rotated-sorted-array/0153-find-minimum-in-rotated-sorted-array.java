class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int minAns = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[start] <= nums[mid]) {
                minAns = Math.min(minAns, nums[start]);
                start = mid + 1;
            } else {
                minAns = Math.min(minAns, nums[mid]);
                end = mid - 1;
            }
        }
        return minAns;
    }
}