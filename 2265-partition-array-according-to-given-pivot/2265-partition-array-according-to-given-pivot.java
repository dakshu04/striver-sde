class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int start = 0;
        int end = n - 1;
        for(int i = 0; i < n; i++) {
            if(nums[i] < pivot) {
                ans[start++] = nums[i];
            }
        }
        for(int j = n - 1; j >= 0; j--) {
            if(nums[j] > pivot) {
                ans[end--] = nums[j];
            }
        }
        while(start <= end) {
            ans[start++] = pivot;
        }
        return ans;
    }
}