class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        for(int i = 1; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = ans.get(i - 1);
            currRow.add(1);
            for(int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currRow.add(1);
            ans.add(currRow);
        }
        return ans;
    }
}