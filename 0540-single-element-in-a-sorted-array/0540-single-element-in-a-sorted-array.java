class Solution {
    public int singleNonDuplicate(int[] nums) {
        //TC->O(n),SC->O(n)
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int num :  map.keySet()) {
            if(!(map.get(num) > 1)) {
                return num;
            }
        }
        return -1;
    }
}