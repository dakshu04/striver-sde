class Solution {
    private void reverse(int[] nums, int start, int end) {
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        //find pivotIdx
        int pivotIdx = -1;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                pivotIdx = i;
                break;
            }
        }
        if(pivotIdx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        //next greater elmnt to make no. just greater
        for(int i = n - 1; i >= 0; i--) {
            if(nums[pivotIdx] < nums[i]) {
                swap(nums, pivotIdx, i);
                break;
            }
        }
        //reverse all no. in btw
        reverse(nums, pivotIdx + 1, n - 1);
    }
}