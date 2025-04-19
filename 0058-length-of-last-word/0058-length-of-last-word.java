class Solution {
    public int lengthOfLastWord(String s) {
        int lastWordLength = 0;
        StringBuilder strB = new StringBuilder();
        s = s.trim();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ') {
                strB.append(s.charAt(i));
                lastWordLength++;
            } else {
                break;
            }
        }
        return lastWordLength;
    }
}