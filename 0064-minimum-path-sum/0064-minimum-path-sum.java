class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Create a 2D dp array to store the minimum path sum to each cell
        int[][] dp = new int[m][n];
        
        // Initialize the first cell
        dp[0][0] = grid[0][0];
        
        // Initialize the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        
        // Initialize the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        
        // Fill in the rest of the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        
        // The bottom-right corner contains the minimum path sum
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[][] grid1 = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println(solution.minPathSum(grid1)); // Output: 7
        
        // Example 2
        int[][] grid2 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println(solution.minPathSum(grid2)); // Output: 12
    }
}
