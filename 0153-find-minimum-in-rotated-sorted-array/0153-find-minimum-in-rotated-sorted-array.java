class Solution {
    public int findMin(int[] nums) {
        int minAns = Integer.MAX_VALUE;
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            if(nums[start] <= nums[end]) minAns = Math.min(nums[start], minAns);
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