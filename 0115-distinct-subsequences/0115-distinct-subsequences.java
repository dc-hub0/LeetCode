class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[i][j] will store the number of distinct subsequences of s[0...i-1] which equal t[0...j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: empty substring of t matches empty substring of s
        dp[0][0] = 1;
        
        // Initialize dp[0][j] = 0 for j > 0 because non-empty t can't match empty s
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }
        
        // Initialize dp[i][0] = 1 for i > 0 because any non-empty s matches empty t
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the characters match, we have two choices: use s[i-1] or ignore it
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // Characters don't match, so we can only ignore s[i-1]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // The answer is stored in dp[m][n]
        return dp[m][n];
    }
}
