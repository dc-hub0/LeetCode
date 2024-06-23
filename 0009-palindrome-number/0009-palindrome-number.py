class Solution:
    def isPalindrome(self, x):

        if x < 0:
            return False
   
        str_x = str(x)

        return str_x == str_x[::-1]

# Examples
solution = Solution()
print(solution.isPalindrome(121))  
print(solution.isPalindrome(-121))  
print(solution.isPalindrome(10))   
