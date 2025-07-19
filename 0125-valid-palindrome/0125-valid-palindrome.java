class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            if(!Character.isLetterOrDigit(s.charAt(start))) {
                //char should be either letter or digit
                start++;
            } else if(!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if(Character.toLowerCase(s.charAt(end)) != Character.toLowerCase(s.charAt(start))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}