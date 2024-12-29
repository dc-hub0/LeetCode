class Solution {
    public int numWays(String[] words, String target) {
        final int MOD = 1000000007;
        int m = target.length();
        int n = words[0].length();
        
        // Frequency array
        int[][] freq = new int[26][n];
        for (String word : words) {
            for (int j = 0; j < n; j++) {
                freq[word.charAt(j) - 'a'][j]++;
            }
        }
        
        // DP array
        long[] dp = new long[m + 1];
        dp[0] = 1; // Base case
        
        for (int j = 0; j < n; j++) {
            // Iterate backwards to prevent overwriting
            for (int i = m - 1; i >= 0; i--) {
                char c = target.charAt(i);
                dp[i + 1] = (dp[i + 1] + dp[i] * freq[c - 'a'][j]) % MOD;
            }
        }
        
        return (int) dp[m];
    }
}
