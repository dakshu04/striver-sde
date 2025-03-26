class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        for(int i = 1; i < numRows; i++) {
            List<Integer> currList = new ArrayList<>();
            List<Integer> prevList = ans.get(i - 1);
            currList.add(1);
            for(int j = 1; j < i; j++) {
                currList.add(prevList.get(j - 1) + prevList.get(j));
            }
            currList.add(1);
            ans.add(currList);
        }
        return ans;
    }
}