class Solution {
    public int removeDuplicates(int[] nums) {
    //    //TC->O(n),SC->O(n)
    //     //Use LinkedHashSet to have ans in ascending order
    //     int n = nums.length;
    //     LinkedHashSet<Integer> hs = new LinkedHashSet<>();
    //     for(int i = 0; i < n; i++) {
    //         hs.add(nums[i]);
    //     }
    //     int idx = 0;
    //     for(int num : hs) {
    //         nums[idx++] = num;
    //     }
    //     return idx;

    //      TC->O(n),SC->O(1);
            int ele = nums[0];
            int n = nums.length;
            int idx = 1;
            for(int i = 1; i < n; i++) {
                if(nums[i] != ele) {
                    nums[idx++] = nums[i];
                    ele = nums[i];
                }
            }
        return idx;
    }
}