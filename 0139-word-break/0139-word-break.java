import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        Set<String> wordSet = new HashSet<>(wordDict);
        dp[0] = true; // Empty string is always true
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println(solution.wordBreak(s1, wordDict1)); // Output: true

        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println(solution.wordBreak(s2, wordDict2)); // Output: true

        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(solution.wordBreak(s3, wordDict3)); // Output: false
    }
}
