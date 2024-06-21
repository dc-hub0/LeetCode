import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(map.get(c) + 1, left);
            }
            map.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        String s1 = "abcabcbb";
        System.out.println(sol.lengthOfLongestSubstring(s1)); // Output: 3

        // Example 2
        String s2 = "bbbbb";
        System.out.println(sol.lengthOfLongestSubstring(s2)); // Output: 1

        // Example 3
        String s3 = "pwwkew";
        System.out.println(sol.lengthOfLongestSubstring(s3)); // Output: 3
    }
}
