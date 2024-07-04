class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the starting or ending cell has an obstacle, return 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        // Create a 2D array to store the number of unique paths to each cell
        int[][] dp = new int[m][n];
        
        // Initialize the first cell
        dp[0][0] = 1;
        
        // Initialize the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 1) ? 0 : dp[0][j-1];
        }
        
        // Initialize the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 1) ? 0 : dp[i-1][0];
        }
        
        // Fill in the rest of the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        // The bottom-right corner contains the number of unique paths
        return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[][] obstacleGrid1 = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid1)); // Output: 2
        
        // Example 2
        int[][] obstacleGrid2 = {
            {0, 1},
            {0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid2)); // Output: 1
    }
}
