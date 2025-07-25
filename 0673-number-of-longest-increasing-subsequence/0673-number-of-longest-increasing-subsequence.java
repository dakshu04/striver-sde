import java.util.*;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n]; // LIS length ending at i
        int[] count = new int[n];  // number of LIS ending at i

        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, length[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (length[i] == maxLen) {
                result += count[i];
            }
        }

        return result;
    }
}
