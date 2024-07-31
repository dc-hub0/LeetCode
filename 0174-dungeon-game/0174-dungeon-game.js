function calculateMinimumHP(dungeon) {
    let m = dungeon.length;
    let n = dungeon[0].length;

    let dp = Array.from({ length: m }, () => Array(n).fill(0));
    
    dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
 
    for (let i = m - 2; i >= 0; i--) {
        dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
    }
    
  
    for (let j = n - 2; j >= 0; j--) {
        dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
    }

    for (let i = m - 2; i >= 0; i--) {
        for (let j = n - 2; j >= 0; j--) {
            let minHealthOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
            dp[i][j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
        }
    }
    
    return dp[0][0];
}


console.log(calculateMinimumHP([[-2,-3,3],[-5,-10,1],[10,30,-5]]));
console.log(calculateMinimumHP([[0]])); 
