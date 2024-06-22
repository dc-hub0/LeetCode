class Solution:
    def scoreOfString(self, s):
        score = 0
        for i in range(1, len(s)):
            score += abs(ord(s[i]) - ord(s[i-1]))
        return score

# Example usage
solution = Solution()

# Example 1
s1 = "hello"
print(solution.scoreOfString(s1))  # Output: 13

# Example 2
s2 = "zaz"
print(solution.scoreOfString(s2))  # Output: 50
