class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 2D array to store the number of unique paths to each cell
        int[][] dp = new int[m][n];
        
        // Initialize the first row and the first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Fill in the rest of the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        // The bottom-right corner contains the number of unique paths
        return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int m1 = 3, n1 = 7;
        System.out.println(solution.uniquePaths(m1, n1)); // Output: 28
        
        // Example 2
        int m2 = 3, n2 = 2;
        System.out.println(solution.uniquePaths(m2, n2)); // Output: 3
    }
}
