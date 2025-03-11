class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();          // Get the length of the input string
        int[] count = new int[3];    // Array to count occurrences of 'a', 'b', and 'c'
        int left = 0;                // Initialize the left pointer of the sliding window
        int result = 0;              // Initialize the result to store the count of valid substrings

        for (int right = 0; right < n; right++) {   
            // Move the right pointer from the beginning to the end of the string
            count[s.charAt(right) - 'a']++;         
            // Increment the count for the current character

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // Check if the current window contains at least one 'a', 'b', and 'c'
                result += n - right;               
                // Add the number of valid substrings from the current right to the end
                count[s.charAt(left) - 'a']--;     
                // Decrement the count for the character at the left pointer
                left++;                            
                // Move the left pointer to the right to shrink the window
            }
        }

        return result;    
        // Return the total count of valid substrings
    }
}