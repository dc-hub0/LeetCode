class Solution:
    def minKBitFlips(self, nums, k):
        n = len(nums)
        flip_count = 0
        flipped = [0] * n
        current_flips = 0
        
        for i in range(n):
            if i >= k:
                current_flips ^= flipped[i - k]
                
            if (nums[i] ^ current_flips) == 0:
                if i + k > n:
                    return -1
                flip_count += 1
                current_flips ^= 1
                if i < n:
                    flipped[i] ^= 1
                
        return flip_count

# Examples
solution = Solution()
print(solution.minKBitFlips([0,1,0], 1))  # Output: 2
print(solution.minKBitFlips([1,1,0], 2))  # Output: -1
print(solution.minKBitFlips([0,0,0,1,0,1,1,0], 3))  # Output: 3
