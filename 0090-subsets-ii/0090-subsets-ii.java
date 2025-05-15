class Solution {
    public void fun(int idx, List<Integer> curr,Set<List<Integer>> res, int[] nums) {
        if(idx == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        curr.add(nums[idx]);
        fun(idx + 1, curr, res, nums);
        curr.remove(curr.size() - 1);
        fun(idx + 1, curr, res, nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);//handline duplicate array
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        fun(0, curr, res, nums);
        return new ArrayList<>(res);
    }
}