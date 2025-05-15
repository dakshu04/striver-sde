class Solution {
    public void fun(int idx, List<Integer> curr, List<List<Integer>> list, int[] nums) {
        list.add(new ArrayList<>(curr));
        for(int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i - 1] == nums[i]) {
                continue;
            }
            curr.add(nums[i]);
            fun(i + 1, curr, list, nums);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        fun(0, new ArrayList<>(), list, nums);
        return list;
    }
}