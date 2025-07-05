class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for(int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1))  {
                temp.add(nums[i]);
            } else {
                // Index at which the current element must be placed
                int idx = Collections.binarySearch(temp, nums[i]);
                if(idx < 0) idx = -(idx + 1);
                // Place the current element in the subsequence
                temp.set(idx, nums[i]);
            }
        }
        return temp.size();
    }
}