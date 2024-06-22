class Solution:
    MOD = 10**9 + 7

    def kInversePairs(self, n, k):
        dp = [[0] * (k + 1) for _ in range(n + 1)]
        dp[0][0] = 1  # Base case

        for i in range(1, n + 1):
            for j in range(0, k + 1):
                dp[i][j] = dp[i - 1][j] 
                if j > 0:
                    dp[i][j] += dp[i][j - 1]
                if j >= i:
                    dp[i][j] -= dp[i - 1][j - i]
                dp[i][j] = (dp[i][j] + self.MOD) % self.MOD 
        return dp[n][k]

solution = Solution()

# Example 1
n1 = 3
k1 = 0
print(solution.kInversePairs(n1, k1))  # Output: 1

# Example 2
n2 = 3
k2 = 1
print(solution.kInversePairs(n2, k2))  # Output: 2
