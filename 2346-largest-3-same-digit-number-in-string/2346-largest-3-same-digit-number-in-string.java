class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        for(int i = 0; i < num.length() - 2; i++) {
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)) {
                String triplet = num.substring(i, i + 3);
                if(triplet.compareTo(ans) > 0) { // lexicographically triplet>ans e.g.7>5 will give > 0
                    ans = triplet;
                }
            }
        }
        return ans;
    }
}