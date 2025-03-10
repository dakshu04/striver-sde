class Solution {
    public long countOfSubstrings(String word, int k) {
        int[][] frequencies = new int[2][128]; // 2D array to track vowels and their frequencies
        long response = 0;
        int currentK = 0, vowels = 0, extraLeft = 0;
        int left = 0; // Separate left pointer

        // Mark vowels in the first row of frequencies
        for (char c : "aeiou".toCharArray()) {
            frequencies[0][c] = 1;
        }

        // Process right pointer separately
        for (int right = 0; right < word.length(); right++) {
            char rightChar = word.charAt(right);

            // Handle vowels
            if (frequencies[0][rightChar] == 1) { 
                frequencies[1][rightChar]++; 
                if (frequencies[1][rightChar] == 1) { // Newly found vowel
                    vowels++;
                }
            } 
            // Handle non-vowel characters
            else {
                currentK++;
            }

            // Process left pointer separately to shrink the window
            while (currentK > k) {
                char leftChar = word.charAt(left);
                if (frequencies[0][leftChar] == 1) { // If it's a vowel
                    frequencies[1][leftChar]--;
                    if (frequencies[1][leftChar] == 0) {
                        vowels--;
                    }
                } else { 
                    currentK--; 
                }
                left++;
                extraLeft = 0;
            }

            // Further adjustments for extra left vowels
            while (vowels == 5 && currentK == k && left < right 
                    && frequencies[0][word.charAt(left)] == 1 
                    && frequencies[1][word.charAt(left)] > 1) {
                extraLeft++;
                frequencies[1][word.charAt(left)]--; 
                left++;
            }

            // If conditions match, count the valid substrings
            if (currentK == k && vowels == 5) {
                response += (1 + extraLeft);
            }
        }

        return response;
    }
}
