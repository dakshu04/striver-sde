class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int num = 1;
        int index = 0;
        while(num <= n && index < target.length) {
            if(num == target[index]) {
                result.add("Push");
                index++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
            num++;
        }
        return result;
    }
}