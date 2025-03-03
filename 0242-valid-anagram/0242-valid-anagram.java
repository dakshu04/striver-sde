class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m) {
            return false;
        }
        int[] freq = new int[26]; //assuming only lowercase eng character
        for(int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++; //asci value of a is 97
            freq[t.charAt(i) - 'a']--; //e.g c-a = 99-97=2 0-baseIndex
        }
        for(int cnt : freq) {
            if(cnt != 0) {
                return false;
            }
        }
        return true;
    }
}