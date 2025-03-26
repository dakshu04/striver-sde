class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void rev(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        //just right side me element bada h kya?
        int pivotIdx = -1;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                pivotIdx = i;
                break;
            }
        }
        if(pivotIdx == -1) {
            rev(nums, 0, n - 1);
            return;
        }
        for(int i = n - 1; i >= 0; i--) {
            if(nums[pivotIdx] < nums[i]) {
                swap(nums, pivotIdx, i);
                break;
            }
        }
        rev(nums, pivotIdx + 1, n - 1);
    }
}